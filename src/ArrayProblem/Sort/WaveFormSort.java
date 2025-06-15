package ArrayProblem.Sort;

import java.util.Arrays;

import static ArrayProblem.Sort.Sort.*;

public class WaveFormSort {
    public static void main(String[] args) {
        int[] arr = {20,10,8,4,2,6};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void solution(int[] arr){
        for(int i=0; i<arr.length; i+=2){
            int last = arr.length-1-i;
            int max = minElement(arr,last);
            swap(arr,max,last);
        }
//        int n = arr.length;
//        for(int i=0; i<n/2;){
//            int temp = arr[]
//            i+=2;
//        }
    }
}
