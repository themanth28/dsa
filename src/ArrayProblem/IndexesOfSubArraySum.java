package ArrayProblem;

import java.util.ArrayList;

public class IndexesOfSubArraySum {
    public static void main(String[] args) {
        int[] arr = {19 ,23, 15, 6, 6, 2, 28, 2};
        int tar = 2;
        System.out.println(subarraySum(arr,tar));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here=
        ArrayList<Integer> sol = new ArrayList<>();
        int n = arr.length;
        int sum = 0;
        int count = 1;
        sol.add(count);
        for(int i=0; i<n; i++){
            sum = sum+arr[i];
            if(sum==target){
                sol.add(i+1);
                System.out.println("1290");
                return sol;
            } else if (sum>target) {
                sum = sum - arr[count-1];
                sum = sum - arr[i];
                sol.remove(count-1);
                count++;
                sol.add(count);
                i--;
            }
        }
        sol.remove(0);
        sol.add(-1);
        return sol;
    }
}
