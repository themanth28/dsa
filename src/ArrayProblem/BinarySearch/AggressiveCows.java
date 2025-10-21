package ArrayProblem.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int [] arr = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println(longestDistance(arr,cows));
    }
    static int longestDistance(int[] stalls, int cows){
        Arrays.sort(stalls);
        System.out.println(Arrays.toString(stalls));
        int start = 1;
        int n = stalls.length;
        int end = stalls[n-1] - stalls[0];
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int count = 1;
            int lastPlacedCow = stalls[0];

            for (int i = 1; i < n; i++) {
                if (stalls[i] - lastPlacedCow >= mid) {
                    lastPlacedCow = stalls[i];
                    count++;
                }
            }
            if (count >= cows) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}