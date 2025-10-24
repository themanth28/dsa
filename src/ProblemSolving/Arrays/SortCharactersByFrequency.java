package ProblemSolving.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String str = "Aabb";
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        freqMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> {
                    char ch = entry.getKey();
                    int freq = entry.getValue();
                    for (int i = 0; i < freq; i++) {
                        result.append(ch);
                    }
                });

        return result.toString();
    }
}
