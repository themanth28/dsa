package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctElements {
    public static void main(String[] args) {
        String str = "qaabcccccc";
        int k = 2;
        System.out.println(longestSubstring(str,k));
    }
    static int longestSubstring(String str, int k){
        int l=0, r=0, maxLen=0, n=str.length();
        Map<Character,Integer> map = new HashMap<>();
        while (r<n){
            map.put(str.charAt(r), r);
            if(map.size()>k){
                int c = map.get(str.charAt(l));
                map.remove(str.charAt(l));
                l = c+1;
            }
            if(map.size()<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
