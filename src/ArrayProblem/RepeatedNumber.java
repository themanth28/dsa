package ArrayProblem;

import java.util.Arrays;

public class RepeatedNumber {
    public static void main(String[] args) {

        int[] arr = {2,1,3,2,1};
        int n = 3;
        System.out.println(Arrays.toString(twoRepeated(n, arr)));

    }
    static int[] twoRepeated(int n, int[] arr) {

        int c = 0;
        int[] ans = {0,0} ;

        // Your code here
        for(int i=1; i<n+2; i++){
            if(arr[i-1] >= arr[i]){
                ans[c] = arr[i];
                c++;
                System.out.println(Arrays.toString(ans));
            }
        }
        if(ans[1] == 0){
            ans[1] = arr[n+2-1];
        }
        return ans ;
    }
}
