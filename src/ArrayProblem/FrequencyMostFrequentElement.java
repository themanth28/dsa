package ArrayProblem;

import java.util.Arrays;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
public class FrequencyMostFrequentElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 0;
        System.out.println(maxFrequency(arr,k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int L = 0;
        int R;
        long totalSum = 0;
        int ans = 0;

        for(R = 0; R < nums.length; R++){
            totalSum += nums[R];
            while((long) nums[R] * (R-L+1) > totalSum + k){
                //sum can't be achieved in K moves, hence shrink the window
                totalSum -= nums[L];
                L++;
            }
            //expand the window
            ans = Math.max(ans,R-L+1);
        }
        return ans;
    }
}
