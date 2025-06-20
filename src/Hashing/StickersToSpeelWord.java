package Hashing;

import java.util.HashMap;
import java.util.Map;

public class StickersToSpeelWord {
    public static void main(String[] args) {
        String[] strings = {"with","example","science"};
        String str = "thehat";
        System.out.println(minStickers(strings,str));
    }
    public static int minStickers(String[] stickers, String target) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        Map<String, Map<Character, Integer>> stringMapMap = new HashMap<>();

        for (String s : stickers){
            for (char c : s.toCharArray()){
                characterIntegerMap.put(c,characterIntegerMap.getOrDefault(c,0)+1);
            }
            Map<Character, Integer> map = new HashMap<>(characterIntegerMap);
            stringMapMap.put(s,map);
            characterIntegerMap.clear();
        }

        Map<Character, Integer> targetMap = new HashMap<>();

        for (char c : target.toCharArray()){
            targetMap.put(c,targetMap.getOrDefault(c,0)+1);
        }

        int count = 0;
        System.out.println(stringMapMap);
        System.out.println(targetMap);



        return count;

    }
}
