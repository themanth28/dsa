package lld.LRUCache;

import java.util.*;

// Thread-safe LRU Cache Implementation (HashMap + DoublyLinkedList)
public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node> cache;
    private final Node head, tail; // dummy nodes for easy pointer handling

    // Doubly Linked List node
    private class Node {
        K key;
        V value;
        Node prev, next;
        Node(K key, V value) { this.key = key; this.value = value; }
    }

    // Constructor
    public LRUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    // Get value (thread-safe)
    public synchronized V get(K key) {
        if (!cache.containsKey(key)) return null;
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    // Put key-value (thread-safe)
    public synchronized void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // update value
            moveToHead(node);
        } else {
            if (cache.size() == capacity) removeLRU();
            Node node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
        }
    }

    // Remove least recently used node
    private void removeLRU() {
        Node lru = tail.prev;
        if (lru == head) return; // safety
        removeNode(lru);
        cache.remove(lru.key);
    }

    // Move a node to head (recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Add node next to head
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Remove node from its position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Display cache for debugging
    public synchronized void display() {
        Node curr = head.next;
        System.out.print("Cache: ");
        while (curr != tail) {
            System.out.print(curr.key + "=" + curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Demo
    public static void main(String[] args) {
        try {
            LRUCache<Integer, String> cache = new LRUCache<>(3);

            cache.put(1, "A");
            cache.put(2, "B");
            cache.put(3, "C");
            cache.display(); // A, B, C

            cache.get(1); // Access 1 => becomes most recent
            cache.display();

            cache.put(4, "D"); // Removes least recently used (2)
            cache.display();

            System.out.println("Get(3): " + cache.get(3));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
