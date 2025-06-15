package ArrayProblem.SlidingWindowTwoPointers;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(subArraySum(nums,target));
    }

    private static int subArraySum(int[] nums, int tar) {
        int sol = Integer.MAX_VALUE, left = 0, right = 0, n = nums.length, sum=0;
        while (right < n){
            sum += nums[right];
            while (left<n && sum >= tar){
                sol =  Math.min(sol,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return sol == Integer.MAX_VALUE ? 0 : sol;
    }
}
