package BitManipulation;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {0, 8, 0, 0, 0, 23};
        System.out.println(maxSubarrays(arr));
    }
    public static int maxSubarrays(int[] nums) {
        int count = 0;
        int right = 0;
        int n = nums.length;
        int leftNum = nums[0];

        while (right < n) {
            leftNum &= nums[right];
            if(leftNum == 0){
                count++;
                if(right+1 < n) {
                    leftNum = nums[right+1];
                }
            }
            right++;
        }
        return Math.max(1,count);
    }
}
