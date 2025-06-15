package ArrayProblem.SlidingWindowTwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    static int numberOfSubstrings(String s) {
        int left = 0, right = 0, n = s.length(), count = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) {
                count += n - right;

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            right++;
        }

        return count;
    }

}
