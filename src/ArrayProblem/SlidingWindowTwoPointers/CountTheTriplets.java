package ArrayProblem.SlidingWindowTwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CountTheTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2};
        System.out.println(countTriplet(arr));
    }
    static int countTriplet(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int sum = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        return count;
    }
}