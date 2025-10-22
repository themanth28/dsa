package lld.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Custom Exception for Stack/Queue
class EmptyDataStructureException extends Exception {
    public EmptyDataStructureException(String message) { super(message); }
}

// ----------------- STACK -----------------
class Stack<T> {
    private final int capacity;
    private final List<T> elements;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayList<>();
    }

    public void push(T value) throws Exception {
        if (elements.size() >= capacity) throw new Exception("Stack Overflow!");
        elements.add(value);
        System.out.println("Pushed: " + value);
    }

    public T pop() throws EmptyDataStructureException {
        if (elements.isEmpty()) throw new EmptyDataStructureException("Stack Underflow!");
        T value = elements.remove(elements.size() - 1);
        System.out.println("Popped: " + value);
        return value;
    }

    public T peek() throws EmptyDataStructureException {
        if (elements.isEmpty()) throw new EmptyDataStructureException("Stack is empty!");
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() { return elements.isEmpty(); }
    public boolean isFull() { return elements.size() == capacity; }

    public void display() {
        System.out.println("Stack Elements (top -> bottom): " + elements);
    }
}

// ----------------- QUEUE -----------------
class Queue<T> {
    private final int capacity;
    private final LinkedList<T> elements;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.elements = new LinkedList<>();
    }

    public void enqueue(T value) throws Exception {
        if (elements.size() >= capacity) throw new Exception("Queue Overflow!");
        elements.addLast(value);
        System.out.println("Enqueued: " + value);
    }

    public T dequeue() throws EmptyDataStructureException {
        if (elements.isEmpty()) throw new EmptyDataStructureException("Queue Underflow!");
        T value = elements.removeFirst();
        System.out.println("Dequeued: " + value);
        return value;
    }

    public T peek() throws EmptyDataStructureException {
        if (elements.isEmpty()) throw new EmptyDataStructureException("Queue is empty!");
        return elements.getFirst();
    }

    public boolean isEmpty() { return elements.isEmpty(); }
    public boolean isFull() { return elements.size() == capacity; }

    public void display() {
        System.out.println("Queue Elements (front -> rear): " + elements);
    }
}

// ----------------- DEMO -----------------
public class StackQueueDemo {
    public static void main(String[] args) {
        try {
            System.out.println("=== STACK DEMO ===");
            Stack<Integer> stack = new Stack<>(5);
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();
            stack.pop();
            stack.display();
            System.out.println("Peek: " + stack.peek());

            System.out.println("\n=== QUEUE DEMO ===");
            Queue<String> queue = new Queue<>(5);
            queue.enqueue("A");
            queue.enqueue("B");
            queue.enqueue("C");
            queue.display();
            queue.dequeue();
            queue.display();
            System.out.println("Peek: " + queue.peek());

        } catch (EmptyDataStructureException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }
}
