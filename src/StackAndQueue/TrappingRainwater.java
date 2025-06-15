package StackAndQueue;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Finding total: "+findTotal(arr));
    }

    public static int findTotal(int[] arr){
        int leftMax = 0, rightMax = 0, total = 0, left = 0, right = arr.length-1;

        while (left<right){
            if(arr[left]<=arr[right]){
                if(leftMax>arr[left]){
                    total += leftMax - arr[left];
                }else {
                    leftMax = arr[left];
                }
                left = left + 1;
            }else {
                if(rightMax>arr[right]){
                    total += rightMax - arr[right];
                }else {
                    rightMax = arr[right];
                }
                right = right - 1;
            }
        }
        return total;
    }
}
