package ArrayProblem;

import java.util.Arrays;

public class CountFairPairs {
    public static void main(String[] args) {
        int[] arr = {1,7,9,2,5};
        int l = 11;
        int h = 11;
        System.out.println(countFairPairs(arr,l,h));
    }
    public static long countFairPairs(int[] nums, int lower, int upper) {
        System.out.println(1<<1);
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        int left = 0;
        int right = 1;

        while (left < n - 1) { // We stop at n-1 because we need a pair
            if (right < n) {
                long sum = (long) nums[left] + nums[right];
                if (sum >= lower && sum <= upper) {
                    ans++;
                }
                if (sum >= upper || right == n - 1) {
                    left++;
                    right = left + 1;
                } else {
                    right++;
                }
            } else {
                left++;
                right = left + 1;
            }
        }

        return ans;
    }
}
