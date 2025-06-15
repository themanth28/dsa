package ArrayProblem.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] listA = {1,2,3};
        int[] listB = {4,5,6};
        System.out.println(findMedianSortedArrays(listA,listB));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = (n1+n2+1) / 2;
        int start = 0;
        int end = n1;

        while (start<=end){
            int mid1 = start + (end-start)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE , l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE , r2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            if(l1 <= r2 && l2 <= r1){
                if( (n1+n2)%2 == 0){
                    return ((double) ( Math.max(l1,l2) + Math.min(r1,r2) ) / 2.0);
                }
                else {
                    return Math.max(l1,l2);
                }
            } else if (l1 > r2) {
                end = mid1 - 1;
            } else {
                start = mid1+1;
            }
        }

        return 0;

    }

    private static double findSolution(List<Integer> A, List<Integer> B) {

        List<Integer> allAB = new ArrayList<>(A);
        allAB.addAll(B);
        int size = allAB.size();
        if(size % 2 != 0){
            return allAB.get(size/2);
        }else {
            return (double) (allAB.get(size / 2) + allAB.get((size / 2) - 1)) /2;
        }


    }

}
