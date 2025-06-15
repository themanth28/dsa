package ArrayProblem.SlidingWindowTwoPointers;

import java.util.*;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
public class FindAnagramsInString {

    public static void main(String[] args) {
        String s = "cbacbabacd";
        String p = "abc";
        System.out.println(s);
        System.out.println(p);

        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Step 1: Build frequency map for pattern p
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(pMap);
        int left = 0, right = 0;
        int matchCount = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (pMap.containsKey(rChar)) {
                windowMap.put(rChar, windowMap.getOrDefault(rChar, 0) + 1);
                if (windowMap.get(rChar).equals(pMap.get(rChar))) {
                    matchCount++;
                }
            }

            // Maintain the window size
            if (right - left + 1 > p.length()) {
                char lChar = s.charAt(left);
                if (pMap.containsKey(lChar)) {
                    if (windowMap.get(lChar).equals(pMap.get(lChar))) {
                        matchCount--;
                    }
                    windowMap.put(lChar, windowMap.get(lChar) - 1);
                }
                left++;
            }

            if (matchCount == pMap.size()) {
                result.add(left);
            }

            right++;
        }

        return result;

    }


}
