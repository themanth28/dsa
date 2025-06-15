package ProblemSolving;

import java.util.Arrays;

public class ZeroesOnesTwos {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,0,1,0,2};
        sort(arr);
    }

    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        int len = arr.length-1;
        for(int i=0; i< arr.length; i++){
            if(arr[i] == 2){
                temp[len] = 2;
                len--;
            }
            if(arr[i] == 1){
                
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
