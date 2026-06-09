package DP;

import java.util.Arrays;

public class FrogJump{
    public static void main(String[] args) {
        int[] h = {30, 20, 50, 10, 40};
        int[] dp = new int[h.length+1];
        Arrays.fill(dp,-1);
//        System.out.println(recursive(h,h.length-1));
//        System.out.println(recursiveDp(h, h.length-1, dp));
//        System.out.println(dpSolution(h, h.length, dp));
//        System.out.println(spaceOptimizedDp(h, h.length));
        System.out.println(frogJumpWithK(h.length,h,3));
    }

    static int frogJumpWithK(int n, int[] heights, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }


    public static int spaceOptimizedDp(int[] h, int n){
        int prev1 = 0;
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int fj  = prev1 + Math.abs(h[i]-h[i-1]);
            int sj = Integer.MAX_VALUE;
            if(i>1) sj = prev2 + Math.abs(h[i]-h[i-2]);
            int cur = Math.min(fj,sj);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
    public static int dpSolution(int[] h, int n, int[] dp){
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int first = dp[i-1] + Math.abs(h[i] - h[i-1]);
            int second = Integer.MAX_VALUE;
            if(i>1)
                second = dp[i-2] + Math.abs(h[i] - h[i-2]);
            dp[i] = Math.min(first,second);
        }
        return dp[n-1];
    }
    public static int recursiveDp(int[] h, int n, int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int left = recursiveDp(h, n-1, dp) + Math.abs(h[n] - h[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1)
            right = recursiveDp(h,n-2, dp) + Math.abs(h[n]-h[n-2]);
        return dp[n] = Math.min(left,right);
    }
    public static int recursive(int[] h, int n){
        if(n==0){
            return 0;
        }
        int left = recursive(h, n-1) + Math.abs(h[n] - h[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1)
            right = recursive(h,n-2) + Math.abs(h[n]-h[n-2]);
        return Math.min(left,right);
    }
}
