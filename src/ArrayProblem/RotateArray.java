package ArrayProblem;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArrayOptimized(nums,k);
        System.out.println(Arrays.toString(nums));
    }



//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        for(int i=0;i<k;i++){
//            int l = nums[n-1];
//            for(int j=n-1;j>0;j--){
//                nums[j] = nums[j-1];
//            }
//            nums[0] = l;
//        }
//    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            temp[(i+k)%n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums,k,n);
    }

    static void reverse(int[] arr, int first, int last){
        for(int i=first; i<last/2; i++){
            int t = arr[i];
            arr[i] = arr[last-1-i];
            arr[last-1-i] = t;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void reverseOptimized(int[] arr, int first, int last) {
        while (first<last){
            arr[first] = arr[first] + arr[last];
            arr[last] = arr[first] - arr[last];
            arr[first] = arr[first] - arr[last];
            first++;
            last--;
        }
    }

    private static void rotateArrayOptimized(int[] arr ,int k){
        int n = arr.length;
        k %= n;
//        Left
//        reverseOptimized(arr,0,k-1);
//        reverseOptimized(arr,k,n-1);
//        reverseOptimized(arr,0,n-1);
//        Right
        reverseOptimized(arr,n-k,n-1);
        reverseOptimized(arr,0,n-k-1);
        reverseOptimized(arr,0,n-1);
    }


}
