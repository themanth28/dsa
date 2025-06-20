package Hashing;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String a = "aa";
        String b = "aab";
        System.out.println(canConstruct(a,b));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : ransomNote.toCharArray()){
            if(map.containsKey(ch)){
                int val = map.get(ch);
                map.put(ch,val-1);
                if(val == 0){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
