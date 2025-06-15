package ArrayProblem.SlidingWindowTwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo","bar"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","good"};
        String s = "aaaaaaaaaaaaaa";
        String[] words = {"aa","aa"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) return list;
        System.out.println("String length " + s.length());

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        for (int i = 0; i <= s.length() - totalLen; i++) {
            String sub = s.substring(i, i + totalLen);
            System.out.println(sub);
            Map<String, Integer> seenMap = new HashMap<>();
            boolean isValid = true;

            for (int j = 0; j < totalLen; j += wordLen) {
                String word = sub.substring(j, j + wordLen);
                if (!wordsMap.containsKey(word)) {
                    isValid = false;
                    System.out.println("new");
                    break;
                }
                seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);
                if (seenMap.get(word) > wordsMap.get(word)) {
                    isValid = false;
                    System.out.println(i);
                    i = i + wordLen -1;
                    System.out.println("extra");
                    break;
                }
            }

            if (isValid) {
                list.add(i);
                i = i + wordLen -1;
            }
            System.out.println("list " + list);
            System.out.println(i);
        }

        return list;
    }

}