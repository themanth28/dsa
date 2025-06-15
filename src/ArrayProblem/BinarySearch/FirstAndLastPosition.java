package ArrayProblem.BinarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        int target = 3;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

    static int[] searchRange(int[] nums, int tar){
        int[] ans = {-1,-1};
        ans[0] = binarySearch(nums,tar,true);
        if(ans[0] != -1){
            ans[1] = binarySearch(nums,tar,false);
        }
        return ans;
    }

    static int binarySearch(int[] nums, int tar, boolean firstIndex){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(tar < nums[mid]){
                end = mid - 1;
            } else if (tar > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if(firstIndex){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }


}
