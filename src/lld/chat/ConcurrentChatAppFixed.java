package lld.chat;

import java.util.*;
import java.util.concurrent.*;
import java.time.LocalDateTime;

class Message {
    private final User sender;
    private final String text;
    private final LocalDateTime timestamp;

    public Message(User sender, String text) {
        this.sender = sender;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() { return sender; }
    public String getText() { return text; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

class NotificationService {
    public void notifyUser(User user, Message msg) {
        System.out.println("🔔 Notification: " + user.getName() + ", new message from " + msg.getSender().getName());
    }
}

class ChatRoom {
    private final String roomId;
    private final List<User> users = new CopyOnWriteArrayList<>();
    private final NotificationService notificationService = new NotificationService();

    public ChatRoom(String roomId) {
        this.roomId = roomId;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " joined chat room: " + roomId);
    }

    public synchronized void broadcastMessage(Message msg) {
        for (User user : users) {
            if (!user.equals(msg.getSender())) {
                user.receiveMessage(msg);
                notificationService.notifyUser(user, msg);
            }
        }
    }
}

class User {
    private final String userId;
    private final String name;
    private final ChatRoom chatRoom;

    public User(String userId, String name, ChatRoom chatRoom) {
        this.userId = userId;
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String text) {
        Message msg = new Message(this, text);
        chatRoom.broadcastMessage(msg);
    }

    public void receiveMessage(Message msg) {
        System.out.println(name + " received: \"" + msg.getText() + "\" from " + msg.getSender().getName());
    }

    public String getName() { return name; }
}

public class ConcurrentChatAppFixed {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom("ZohoChatRoom");
        Scanner scanner = new Scanner(System.in);

        User u1 = new User("U1", "Hemanth", room);
        User u2 = new User("U2", "BroBot", room);
        User u3 = new User("U3", "ZohoGuy", room);

        room.addUser(u1);
        room.addUser(u2);
        room.addUser(u3);

        System.out.println("\nWelcome to Zoho Concurrent Chat!");
        System.out.println("Type '<username>: <message>' or 'exit' to quit.\n");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) break;

            if (!line.contains(":")) {
                System.out.println("⚠️ Invalid format! Use <username>: <message>");
                continue;
            }

            String[] parts = line.split(":", 2);
            String user = parts[0].trim();
            String msg = parts[1].trim();

            User sender = switch (user.toLowerCase()) {
                case "hemanth" -> u1;
                case "brobot" -> u2;
                case "zohoguy" -> u3;
                default -> null;
            };

            if (sender == null) {
                System.out.println("❌ Unknown user: " + user);
                continue;
            }

            executor.submit(() -> sender.sendMessage(msg));
        }

        executor.shutdown();
        System.out.println("\nChat session ended.");
        scanner.close();
    }
}
