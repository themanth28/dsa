package ArrayProblem;

import java.util.Arrays;

//Priority queue

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {1};
        int k = 1;
        System.out.println(findKthLargest(arr, k));
    }

    static public int findKthLargest(int[] nums, int k) {

        int count = -1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] kArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                count++;
                max = nums[i];
                kArray[count] = nums[i];
            }
        }
        System.out.println(Arrays.toString(kArray));
        System.out.println(count);
        System.out.println(count-k+1);
        if(k==n){
            return nums[n-1];
        }
        return kArray[count-k+1];
    }
}
