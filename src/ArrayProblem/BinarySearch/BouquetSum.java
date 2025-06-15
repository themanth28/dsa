package ArrayProblem.BinarySearch;

import java.util.Arrays;

public class BouquetSum {
    public static void main(String[] args) {
        int[] days = {7,7,7,7,12,7,7};
        int bouquets = 2;
        int flowers = 3;
        System.out.println(minimumDays(days,bouquets,flowers));
    }

    static int minimumDays(int[] bloomDay, int m, int k){
        long mul = (long) m *k;
        if(mul > bloomDay.length){
            return -1;
        }
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int j : bloomDay){
            if (end < j) {
                end = j;
            }
        }
        int count = 0;
        int sum = 0;
        while (start<=end){
            int mid = start + (end-start)/2;
            for (int day : bloomDay) {
                if (day <= mid) {
                    sum += 1;
                    if (sum == k) {
                        count += 1;
                        sum = 0;
                    }
                }else {
                    sum = 0;
                }
            }
            if(count>=m){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
            count = 0;
            sum = 0;
        }
        return start;
    }
}
