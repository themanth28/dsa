package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        List<Integer> list = new ArrayList<>();
        printSequence(0, arr,list);
    }

    static void printSequence(int ind, int[] arr, List<Integer> list){
        if(ind >= arr.length){
            System.out.println(list);
            return;
        }
        list.add(arr[ind]);
        printSequence(ind+1,arr,list);
        list.remove(list.size() - 1);
        printSequence(ind+1,arr,list);
    }
}