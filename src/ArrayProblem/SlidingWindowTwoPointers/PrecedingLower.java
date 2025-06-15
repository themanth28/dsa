package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashSet;
import java.util.Set;

public class PrecedingLower {
    public static void main(String[] args) {
        int[] arr = {5 ,13 ,2 ,7, 3 ,7 ,6 ,8 ,6, 5, 1};
        int[] arr3 = {3,17,5,1,5,2};
        int[] arr1 = {5,4,3,2,1};
        int[] arr2 = {16,17,5,5,5,2};
//        print(arr2);
//        print(arr1);
//        print(arr);
//        print(arr3);
        printN(arr);
    }

    static void printRec(int start, int end, int[] arr){
        if(start==end){
            return;
        }
        System.out.println();

    }

    static void printN(int[] arr){
        int left = 0, right = 1;
        while (right<arr.length){
            if(arr[left] < arr[right]){
                int mid = right+1;
                int sub = Integer.MAX_VALUE;
                int newR = right;
                while (mid< arr.length){
                    if(arr[mid] > arr[right]){
                        right = mid;
                        left = right;
                        break;
                    }
                    if(arr[right]-arr[mid] <= sub){
                        newR=mid;
                        left=mid-1;
                    }
                    sub = Math.min(arr[right]-arr[mid], sub);
                    mid++;
                }
                if(mid == arr.length){
                    System.out.println(arr[right]);
                    right = newR;
                }
            }else {
                right++;
                left++;
            }
        }
        System.out.println(arr[right-1]);
    }


    static void print(int[] arr){
        int left = 0;
        int right = 1;
        while (right < arr.length){
            if(arr[right - 1] < arr[right] || arr[right] > arr[left]){
                left = right;
            }
            right++;
        }
        Set<Integer> set = new HashSet<>();
        System.out.println("Array: ");
        for (int i=left; i<right; i++){
            set.add(arr[i]);
        }
        System.out.println(set);
    }
}
