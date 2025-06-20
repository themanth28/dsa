package Hashing;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        System.out.println(map);

        return new ArrayList<>(map.values());

//        Map<Character, Integer> map = new HashMap<>();
//        for(char c : strs[0].toCharArray()){
//            map.put(c, map.getOrDefault(c, 0)+1);
//        }
//
//        Map<List<String>, Map<Character, Integer>> mapMap = new HashMap<>();
//
//        mapMap.put(Collections.singletonList(strs[0]), map);
//
//        for(int i=1; i<strs.length; i++){
//            int finalI = i;
//            AtomicBoolean present = new AtomicBoolean(false);
//            mapMap.forEach((key, val) -> {
//                HashMap<Character, Integer> temp = new HashMap<>(mapMap.get(key));
//                for (char c : strs[finalI].toCharArray()){
//                    if (!temp.containsKey(c)) {
//                        present.set(true);
//                        break;
//                    }
//                }
//                if(!present.get()){
//                    Map<Character, Integer> tempMap = new HashMap<>(val);
//                    List<String> list = new ArrayList<>();
//                    key.forEach(k -> list.add(k));
//                    list.add(strs[finalI]);
//                    mapMap.remove(key);
//                    mapMap.put(list,tempMap);
//                }
//            });
//            if(present.get()){
//                Map<Character, Integer> newMap = new HashMap<>();
//                for(char c : strs[0].toCharArray()){
//                    newMap.put(c, newMap.getOrDefault(c, 0)+1);
//                }
//                mapMap.put(Arrays.asList(strs[i]), newMap);
//            }
//        }
//        List<List<String>> ans = new ArrayList<>();
//        mapMap.forEach((key, val) -> ans.add(key));
//        return ans;
    }
}
