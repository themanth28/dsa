package ArrayProblem.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ArrayProblem.Sort.Sort.swap;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,3,3,1};
        System.out.println(Arrays.toString(cycleSort(arr)));;
    }

    static int[] cycleSort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
            System.out.println(Arrays.toString(arr) + " "+ i);
        }
        return arr;
    }
}
