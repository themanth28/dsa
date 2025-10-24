package ProblemSolving.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println(ans(arr,k));
    }

    public static int ans(int[] arr, int k){
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // base case: empty subarray

        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            // check if there is a prefix sum that satisfies (sum - k)
            count += prefixSumCount.getOrDefault(sum - k, 0);

            // record current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
            System.out.println(prefixSumCount + " " + count);
        }

        return count;
    }
}
