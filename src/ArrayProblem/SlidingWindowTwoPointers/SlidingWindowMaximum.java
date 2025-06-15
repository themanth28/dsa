package ArrayProblem.SlidingWindowTwoPointers;

import java.util.Arrays;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
//        int[] arr = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
        int[] arr = {-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
        int k = 7;
        System.out.println(Arrays.toString(maxSlidingWindow(arr,k)));
//        System.out.println(max(new int[]{0,-7,7,4,-2,-10,8}, 0, 6));
    }

    static public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int n = nums.length;
        int[] solution = new int[n - k + 1];
        int sum = 0;
        int tempSum = 0;

        int left = 0;
        int right = k - 1;
        int count = 0;

        int key = nums[0];
        for (int i = 1; i <= right; i++) {
            if (nums[i] > key) {
                key = nums[i];
            }
        }
        solution[count++] = key;

        while (right < n - 1) {
            left++;
            right++;

            if (nums[right] >= key) {
                // New element is the new max
                key = nums[right];
            } else if (nums[left - 1] == key) {
                // Max has slid out of the window, recalculate
//                key = nums[left];
//                for (int i = left + 1; i <= right; i++) {
//                    if (nums[i] > key) {
//                        key = nums[i];
//                    }
//                }
                key = Arrays.stream(nums, left, right+1).max().getAsInt();
            }
            // else: keep using existing key

            solution[count++] = key;
        }

        return solution;
    }

    static int max(int[] arr, int l, int r){

//        int last = arr[r] == arr[arr.length-1]? r :  r-1;
        int last = r;
        System.out.println("last : "+ last);
        return arr[minValue(arr,l,last)];
    }

    private static int minValue(int[] arr, int l, int last) {
        int max = l;
        for(int i = l; i<=last; i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
}
