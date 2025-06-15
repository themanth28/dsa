package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,5,76,2,5,8,2,5,90,8,65,3,1,2,9};
        int[] arr1 = {4,5,6,8,2,7,3,1};
        quickSort(arr1,0,arr1.length-1);
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i<j){
            while (arr[i] <= pivot && i <= high-1){
                i++;
            }
            while (arr[j] > pivot && j >= low+1){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }


}
