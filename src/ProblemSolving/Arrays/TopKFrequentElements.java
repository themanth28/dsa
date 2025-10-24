package ProblemSolving.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();


        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = map.entrySet()
                .stream()
                .sorted((a,b) -> b.getValue() - a.getValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return list.stream().mapToInt(i -> i).toArray();
    }
}
