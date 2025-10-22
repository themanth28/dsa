package lld.LFUCache;

import java.util.*;

// LFU Cache using HashMap + MinHeap (PriorityQueue)
public class LFUCache<K, V> {
    private final int capacity;
    private int time = 0; // timestamp for tie-breaking
    private final Map<K, Node> cache;
    private final PriorityQueue<Node> minHeap; // least freq used on top

    // Node class
    private class Node {
        K key;
        V value;
        int freq;
        int time;

        Node(K key, V value, int freq, int time) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.time = time;
        }
    }

    public LFUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // MinHeap sorted by frequency then time
        this.minHeap = new PriorityQueue<>((a, b) -> 
            (a.freq == b.freq) ? a.time - b.time : a.freq - b.freq
        );
    }

    // Get value
    public synchronized V get(K key) {
        if (!cache.containsKey(key)) return null;
        Node node = cache.get(key);
        minHeap.remove(node); // must reinsert to update order
        node.freq++;
        node.time = ++time;
        minHeap.offer(node);
        return node.value;
    }

    // Put value
    public synchronized void put(K key, V value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            minHeap.remove(node);
            node.value = value;
            node.freq++;
            node.time = ++time;
            minHeap.offer(node);
        } else {
            if (cache.size() == capacity) {
                Node lfu = minHeap.poll(); // least freq node
                if (lfu != null) cache.remove(lfu.key);
            }
            Node newNode = new Node(key, value, 1, ++time);
            cache.put(key, newNode);
            minHeap.offer(newNode);
        }
    }

    // Display cache contents
    public synchronized void display() {
        System.out.print("Cache: ");
        for (Node node : cache.values()) {
            System.out.print("[" + node.key + ":" + node.value + ", f=" + node.freq + "] ");
        }
        System.out.println();
    }

    // Demo
    public static void main(String[] args) {
        try {
            LFUCache<Integer, String> cache = new LFUCache<>(3);

            cache.put(1, "A");
            cache.put(2, "B");
            cache.put(3, "C");
            cache.display();

            cache.get(1); // increase freq of 1
            cache.get(1); // again
            cache.get(3); // increase freq of 3
            cache.display();

            cache.put(4, "D"); // removes key=2 (least freq)
            cache.display();

            System.out.println("Get(1): " + cache.get(1)); // "A"
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
