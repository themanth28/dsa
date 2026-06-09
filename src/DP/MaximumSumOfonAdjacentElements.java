package DP;

public class MaximumSumOfonAdjacentElements {
    public static void main(String[] args) {
        int[] arr = {2,3,4,9};
//        System.out.println(recursive(arr, arr.length-1));
        int[] dp = new int[arr.length];
        dp[0] = 0;
//        System.out.println(recursiveDp(arr,arr.length-1,dp));
//        System.out.println(dpSolution(arr, arr.length, dp));
        System.out.println(spaceOptimizedDp(arr,arr.length));
    }

    public static int spaceOptimizedDp(int[] arr, int n){
        int prev1 = arr[0];
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int pick = arr[i];
            if(i>1){
                pick += prev2;
            }
            int notPick = prev1;
            int curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static int dpSolution(int[] arr, int n, int[] dp){
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            int pick = arr[i];
            if(i>1){
                pick += dp[i-2];
            }
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick,nonPick);
        }
        return dp[n-1];
    }

    public static int recursive(int[] arr, int n){
        if(n==0){
            return arr[n];
        }
        if(n<0){
            return 0;
        }
        int pick = arr[n] + recursive(arr,n-2);
        int notPick = recursive(arr,n-1);

        return Math.max(pick,notPick);
    }

    public static int recursiveDp(int[] arr, int n, int[] dp){
        if(n==0){
            return arr[n];
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int pick = arr[n] + recursive(arr,n-2);
        int notPick = recursive(arr,n-1);

        return dp[n] = Math.max(pick,notPick);
    }
}
