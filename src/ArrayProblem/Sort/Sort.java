package ArrayProblem.Sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {3,4,1,5,6};
        System.out.println(Arrays.toString(arr));
//        selection(arr);
//        sort(arr);
//        insertion(arr);
        selectionDescending(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void insertion(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
                System.out.println(Arrays.toString(arr) + " j " + j);
            }
            System.out.println(Arrays.toString(arr) + " i " + i);
        }
    }

    public static void selection(int[] arr){
        for(int i=0; i<arr.length; i++){
            int last = arr.length-i-1;
            int maxElement = maxElement(arr, last);
            swap(arr,maxElement,last);
        }
    }
    static void selectionDescending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int minElement = minElement(arr, last);
            swap(arr, minElement, last);
        }
    }
    static int minElement(int[] arr, int last) {
        int min = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }
    static int maxElement(int[] arr, int last) {
        int max = 0;
        for(int i = 0; i<=last; i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }

    static void sort(int[] arr){
        for(int i=0; i<arr.length; i++){
            boolean swapped = false;
            for(int j=1; j<arr.length-i;j++){
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
            System.out.println(Arrays.toString(arr) + "i " + i);
        }
    }
}