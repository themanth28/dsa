package ArrayProblem;

import java.util.*;

public class OracleQuestion {
    public static void main(String[] args) {
        int[] arr = {3,4,4,4,4,5,5,5,2,2,2};
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println(list);

        for(int i=0; i<n; i++){

        }

        System.out.println(map);

        return arr;
    }
}
