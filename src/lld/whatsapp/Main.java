package lld.whatsapp;

import java.util.*;
import java.util.concurrent.*;

// Message class
class Message {
    private String content;
    private User sender;
    private Date timestamp;

    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = new Date();
    }

    public String toString() {
        return "[" + timestamp + "] " + sender.getName() + ": " + content;
    }
}

// User class
class User {
    private String name;
    private Set<Chat> chats = ConcurrentHashMap.newKeySet(); // thread-safe set

    public User(String name) { this.name = name; }
    public String getName() { return name; }

    public void joinChat(Chat chat) {
        chats.add(chat);
        chat.addUser(this);
    }

    public void sendMessage(Chat chat, String content) {
        if(!chats.contains(chat)) {
            System.out.println("You are not part of this chat!");
            return;
        }
        chat.broadcastMessage(this, content);
    }

    public void receiveMessage(Message message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}

// Chat class (supports concurrency)
class Chat {
    private String chatName;
    private Set<User> participants = ConcurrentHashMap.newKeySet(); // thread-safe
    private List<Message> messages = Collections.synchronizedList(new ArrayList<>()); // thread-safe list

    public Chat(String chatName) { this.chatName = chatName; }

    public void addUser(User user) {
        participants.add(user);
    }

    // Thread-safe message broadcasting
    public void broadcastMessage(User sender, String content) {
        Message message = new Message(sender, content);
        messages.add(message); // synchronized list handles concurrency
        notifyUsers(message, sender);
    }

    private void notifyUsers(Message message, User sender) {
        for(User user : participants) {
            if(!user.equals(sender)) {
                // notify concurrently using executor
                Executors.newSingleThreadExecutor().submit(() -> user.receiveMessage(message));
            }
        }
    }

    public void showChatHistory() {
        System.out.println("Chat History for " + chatName + ":");
        synchronized(messages) {
            for(Message msg : messages) System.out.println(msg);
        }
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        Chat groupChat = new Chat("Friends");
        alice.joinChat(groupChat);
        bob.joinChat(groupChat);
        charlie.joinChat(groupChat);

        // Simulate concurrent messaging
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> alice.sendMessage(groupChat, "Hey everyone!"));
        executor.submit(() -> bob.sendMessage(groupChat, "Hi Alice!"));
        executor.submit(() -> charlie.sendMessage(groupChat, "Hello guys!"));

        executor.shutdown();
        while(!executor.isTerminated()) {} // wait for all messages

        groupChat.showChatHistory();
    }
}
