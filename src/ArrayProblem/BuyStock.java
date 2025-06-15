package ArrayProblem;

public class BuyStock {

    public static void main(String[] args) {
        int[] arr = {8,5,9,2,4,9};
        System.out.println(maxProfit(arr));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    static int maxProfit(final int[] A) {
        int n = A.length-1;
        int profit = 0;
        int pieces = A[0];
        for(int i=0; i<n; i++){
            if(A[i+1] > A[i] && A[i]<pieces){
                profit = A[i+1] - A[i] + profit;
                if(A[i]<pieces){
                    pieces = A[i];
                }
                i++;
            }
        }
        return profit;
    }
}
