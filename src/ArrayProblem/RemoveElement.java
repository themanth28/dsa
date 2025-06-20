package ArrayProblem;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int t = 3;
        System.out.println(removeElement(arr,t));
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int l = nums.length - 1;
        if(nums.length==0){
            return 0;
        }
        if(nums[l] == val) {
            count = 1;
        }
        for ( int i = l-1 ; i >= 0  ; i-- ) {
            if ( nums[i] == val ){
                nums[i] = nums[l-count];
                count = count + 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;


    }
}
