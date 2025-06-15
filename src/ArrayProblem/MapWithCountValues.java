package ArrayProblem;

import java.util.*;

public class MapWithCountValues {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // Adding identical key-value pairs (same key, incrementing count)
        addToMap(map, "apple");
        addToMap(map, "apple");
        addToMap(map, "banana");

        // Print the map
        System.out.println(map);
    }

    // Helper method to increment the count for a key in the map
    public static void addToMap(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);  // If key exists, increment; otherwise, start with 1
    }
}
