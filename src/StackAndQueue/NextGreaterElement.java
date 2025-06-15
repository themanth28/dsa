package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4,12,5,3,1,2,5,3,1,2,4,6};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        int[] arr2 = {2,10,12,1,11};
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(nextGreaterElementII(arr2)));
    }

    public static int[] nextGreaterElement(int[] arr){
        int[] sol = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i= arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                sol[i] = -1;
            }else {
                sol[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return sol;
    }

    public static int[] nextGreaterElementII(int[] arr){
        int[] sol = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i= 2*arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()<=arr[i%(arr.length)]){
                stack.pop();
            }
            if(i< arr.length){
                sol[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[i% arr.length]);
        }
        return sol;
    }
}
