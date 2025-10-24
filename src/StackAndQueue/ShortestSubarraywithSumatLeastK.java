package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class ShortestSubarraywithSumatLeastK {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[] {48,99,37,4,-31}));
        System.out.println(shortestSubarray(new int[] {48,99,37,4,-31}, 140));
    }
    public static int shortestSubarray(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        
        int n = nums.length;
        int res = n+1;
        long[] p = new long[n+1];

        for(int i=0; i<n; i++){
            p[i+1] = p[i] + nums[i];
        }

        System.out.println(Arrays.toString(p));

        for(int i=0; i<=n; i++){

            while(!q.isEmpty() && p[i] - p[q.peekFirst()] >= k){
                res = Math.min(i-q.peekFirst(), res);
                q.removeFirst();
            }

            while(!q.isEmpty() && p[i] <= p[q.peekLast()]){
                q.removeLast();
            }
            
            q.addLast(i);
        }

        return res <= n ? res : -1;
    }
}