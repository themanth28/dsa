package ArrayProblem;

import java.util.Arrays;

public class SortColours {
    public static void main(String[] args) {
        int[] nums = { 2,0,2,1,1,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int a, int b){
        if(a!=b) {
            nums[a] = nums[a] + nums[b];
            nums[b] = nums[a] - nums[b];
            nums[a] = nums[a] - nums[b];
        }
    }

    public static void sort(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid<=high){
            if(nums[mid] == 0){
                sort(nums,low,mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1){
                mid++;
            }
            else {
                sort(nums,mid,high);
                high--;
            }
        }
    }
}
