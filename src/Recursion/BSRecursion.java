package Recursion;

public class BSRecursion {


    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int target = 3;
        int ans = rbs(arr,target,0,arr.length-1);
        System.out.println(ans);
    }

    static int rbs(int[] arr, int tar, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == tar){
            return  mid;
        }
        if(arr[mid] > tar){
            return rbs(arr,tar,start,mid-1);
        }
        return rbs(arr,tar,mid+1,end);
    }
}
