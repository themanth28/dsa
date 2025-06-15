package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "zka";
        System.out.println(substringLongest(str));
    }

    private static int substringLongest(String str) {
        int right = 0, left = 0, count = 0, n = str.length();

        HashMap<Character, Integer> solution = new HashMap<>();

        while(right<n){
            char ch = str.charAt(right);
            if(solution.containsKey(ch)){
                left = Math.max(solution.get(ch)+1, left);
            }
            solution.put(ch, right);
            count = Math.max(right-left+1, count);
            right++;
        }

        return count;
    }
}
