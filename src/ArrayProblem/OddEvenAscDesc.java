package ArrayProblem;

import java.util.Arrays;

public class OddEvenAscDesc {
    public static void main(String[] args) {
//        long[] arr = {1,2,3,5,4,7,10};
        long[] arr = {0,4,5,3,7,2,1};
        System.out.println(Arrays.toString(oddEven(arr)));
    }
    static long[] oddEven(long[] arr){
        int right = arr.length;
        int left = -1;

        long[] temp = new long[arr.length];
        for (long j : arr) {
            if (j % 2 != 0) {
                left++;
                temp[left] = j;
            } else {
                right--;
                temp[right] = j;
            }
        }
        ascSort(temp, right);
        descSort(temp, left+1);
        return temp;
    }

    static void descSort(long[] arr, int left){
        for(int i=0; i<left; i++){
            int last = left-i-1;
            int minElement = minElement(arr, last);
            swap(arr,minElement,last);
        }
    }

    static void ascSort(long[] arr, int right){
        int j = 0;
        for(int i=right; i< arr.length; i++){
            int last = arr.length-j-1;
            int maxElement = maxElement(arr, last,right);
            swap(arr,maxElement,last);
            j++;
        }
    }

    static void swap(long[] arr, int first, int second){
        long temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int minElement(long[] arr, int last) {
        int min = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }

    static int maxElement(long[] arr, int last,int right) {
        int max = right;
        for(int i = right; i<=last; i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
}
