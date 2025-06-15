package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,5,1,7,8,9,12,36,22,8};
        int n = arr.length;
        mergeSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        mergeArrays(arr,low,mid,high);
    }

    private static void mergeArrays(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high+1];
        int left = low;
        int right = mid+1;
        int i=0;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                i++;
                left++;
            }
            else {
                temp[i] = arr[right];
                i++;
                right++;
            }
        }

        while (left <= mid){
            temp[i] = arr[left];
            i++;
            left++;
        }

        while (right <= high){
            temp[i] = arr[right];
            i++;
            right++;
        }

        for(int j=low; j<=high; j++){
            arr[j] = temp[j-low];
        }
    }
}
