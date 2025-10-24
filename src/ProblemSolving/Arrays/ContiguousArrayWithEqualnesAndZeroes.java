package ProblemSolving.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ContiguousArrayWithEqualnesAndZeroes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 0, 0, 0, 1, 0,0,1};
        System.out.println(solution(arr));
    }

    public static int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence of this sum
            }
        }

        return maxLen;
    }
}
