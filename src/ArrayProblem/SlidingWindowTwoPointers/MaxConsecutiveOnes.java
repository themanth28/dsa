package ArrayProblem.SlidingWindowTwoPointers;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(maxOnes(arr,k));
    }
    static int maxOnes(int[] nums, int k){
        int left = 0, maxLen = 0, zeros = 0, right = 0;

//        for (int right = 0; right < nums.length; right++) {
//            if (nums[right] == 0) zeros++;
//
//            while (zeros > k) {
//                if (nums[left] == 0) zeros--;
//                left++;
//            }
//            maxLen = Math.max(maxLen, right - left + 1);
//        }

        while (right<nums.length){
            if(nums[right] == 0) zeros++;
            if(zeros>k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            if(zeros<=k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }

        return maxLen;
    }
}
