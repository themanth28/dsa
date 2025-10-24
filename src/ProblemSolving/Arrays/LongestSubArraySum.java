package ProblemSolving.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;
        System.out.println(solution(arr,k));
        String str = "";
//        str.
    }

    private static int solution(int[] arr, int k) {
        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            int mod = ((sum%k)+k) %k;

            if(map.containsKey(mod)){
                maxLength = Math.max(maxLength, i-map.get(mod));
            }else {
                map.put(mod,i);
            }
            System.out.println(maxLength + " " + map + " " + mod);
        }
        return maxLength;
    }
}
