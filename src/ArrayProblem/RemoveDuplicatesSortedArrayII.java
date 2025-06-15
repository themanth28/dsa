package ArrayProblem;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrayII {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

    }
    static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 2;
        for(int i=2; i<n; i++){
            System.out.println("\nbf " + i + " " + Arrays.toString(nums) + "\n");
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
            System.out.println("\naf " + i + " " + Arrays.toString(nums) + "\n");
            // nums[nums.length-1] = nums[i];
        }
        return j;
    }


}
