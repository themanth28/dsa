package BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> stringList = new ArrayList<>();
        int right = 0, left = 0;
        int n = s.length();
        int xor = 0;
//        int index = 0;
        int count = 0;
        int startingIndex = 0;
        HashMap<String, Integer> map = new HashMap<>();

        while (right<n){
            int c = s.charAt(right);
            xor ^= c;
            if(count == 10){
                String str = s.substring(right-count, right);
                map.put(str,map.getOrDefault(str,0)+1);
                System.out.println(map);
                System.out.println(count);
                count = 0;
            }
            count++;
            right++;
        }


        return stringList;
    }
}

