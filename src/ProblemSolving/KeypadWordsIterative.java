package ProblemSolving;

import java.util.*;

public class KeypadWordsIterative {
    static String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static List<String> possibleWords(int[] arr) {
        List<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        Queue<String> queue = new LinkedList<>();
        queue.add("");  // start with empty string

        for (int digit : arr) {
            if (digit == 0 || digit == 1) continue; // skip 0 and 1

            int size = queue.size();
            String letters = mapping[digit];

            for (int i = 0; i < size; i++) {
                String base = queue.poll();
                for (char ch : letters.toCharArray()) {
                    queue.add(base + ch);
                }
            }
        }

        result.addAll(queue);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4};
        List<String> words = possibleWords(arr);
        System.out.println(words);
    }
}
