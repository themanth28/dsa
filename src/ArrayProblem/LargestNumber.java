package ArrayProblem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        PriorityQueue<String> q = new PriorityQueue<>(
                (a,b) -> (a+b).compareTo(b+a));
        for (int num : nums) {
            q.offer(String.valueOf(num));
        }
        StringBuilder s = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            s.append(nums.length);
        }
    }
}
