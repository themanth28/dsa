package Recursion;

import java.util.Arrays;

public class ReverseNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverseArrayFor(arr);
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        reverseArray(arr1);
    }
    static void reverseArray(int[] arr) {
        recursive(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverseArrayFor(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
//        System.out.println(Arrays.toString(arr));
    }
    static void recursive(int[] arr, int i, int j){
        if(i>=j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        recursive(arr,i+1,j-1);
    }
}
