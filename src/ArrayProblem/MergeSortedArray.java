package ArrayProblem;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1,3,arr2,arr2.length);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
//        int t = nums1.length-1;
//        m=m-1;
//        n=n-1;
//
//
//        for(int i=0; i<=nums2.length; i++){
//            if((t>-1) && (m > -1) && (n > -1) && (nums1[m] > nums2[n])){
//                nums1[t] = nums1[m];
//                m=m-1;
//            }else{
//                nums1[t] = nums2[n];
//                n=n-1;
//            }
//            t=t-1;
//
//        }
    }
}
