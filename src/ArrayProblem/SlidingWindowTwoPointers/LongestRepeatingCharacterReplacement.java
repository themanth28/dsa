package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ADKPSSSSSAAAWW";
        int k = 2;
        System.out.println(solutionCharacter(s,k));
    }

    private static int solutionCharacter(String s, int k) {
        int l=0, r=0, maxLen=0, maxFreq=0, n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        while (r<n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if(r-l+1 - maxFreq > k){
                int c = map.get(s.charAt(l)) - 1;
                map.put(s.charAt(l),c);
                l++;
            }
            System.out.println(map +" "+ l);
            if(r-l+1 - maxFreq <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }

}