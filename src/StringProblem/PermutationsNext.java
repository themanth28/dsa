package StringProblem;

import java.util.*;

public class PermutationsNext {
    public static void main(String[] args) {
        System.out.println(permute("ABC")); // [ABC, ACB, BAC, BCA, CAB, CBA]
        System.out.println(permute("XY"));  // [XY, YX]
        System.out.println(permute("AAA")); // [AAA]
    }

    public static List<String> permute(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // smallest lexicographical permutation
        List<String> result = new ArrayList<>();
        result.add(new String(chars));

        while (nextPermutation(chars)) {
            result.add(new String(chars));
        }

        return result;
    }

    // Generate next lexicographical permutation
    private static boolean nextPermutation(char[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: find first decreasing element from the right
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false; // last permutation reached

        // Step 2: find element just larger than arr[i] to the right
        int j = n - 1;
        while (arr[j] <= arr[i]) j--;

        // Step 3: swap
        swap(arr, i, j);
        System.out.println("swap " + Arrays.toString(arr));
        // Step 4: reverse the subarray after i
        reverse(arr, i + 1, n - 1);

        System.out.println(arr);

        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) swap(arr, start++, end--);
    }
}
