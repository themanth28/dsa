package ProblemSolving;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
//        System.out.println(solution(nums,k));
        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle the case where the subarray starts from index 0

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }


    public static int solution(int[] nums, int k){
        int count = 0;
        int left = 0, right = 1;
        int sum = 0;
        while (left< nums.length && right<nums.length){
            sum = nums[left];
            while (right<nums.length){
                if(sum == k){
                    count++;
                    break;
                }
                sum += nums[right];
                right++;
            }
            left++;
            right = left+1;
        }if(nums[left] == k || (sum == k)){
            count++;
        }

        return count;
    }
}
