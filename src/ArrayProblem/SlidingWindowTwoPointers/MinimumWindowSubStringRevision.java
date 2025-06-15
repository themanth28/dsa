package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubStringRevision {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: BANC
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        String subString = "";
        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        Map<Character,Integer> stringMap = new HashMap<>();
        for(char c : t.toCharArray()){
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c,0)+1);
        }
//        System.out.println(characterIntegerMap.size());

        int r = 0, l = 0, n = s.length(), min = 0, max = 0;
        while (r<n){
            char rChar = s.charAt(r);
            if(characterIntegerMap.containsKey(rChar)){
                stringMap.put(rChar, r);
            }
//            System.out.println(stringMap);
            if(stringMap.size() == characterIntegerMap.size()){
                min = stringMap.values().stream().min(Integer::compareTo).get();
                max = stringMap.values().stream().max(Integer::compareTo).get();
                subString = s.substring(min, max+1);
            }
//            System.out.println(subString+" "+min+ " "+max);
            r++;
        }
        return subString;
    }
}
