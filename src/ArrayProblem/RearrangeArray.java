package ArrayProblem;

import java.util.Arrays;

public class RearrangeArray {

    // Rearrange arr[] so that arr[j] becomes i if arr[i] is j
    public static void rearrange(int[] arr) {

        int n = arr.length;

        // Store new values using modulo
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += i * n;
        }
            System.out.println(Arrays.toString(arr));

        // Extract new values
        for (int i = 0; i < n; i++) {
            arr[i] /= n;
        }


    }

    public static void main(String[] args) {

        int[] arr = {2, 0, 1, 4, 5, 3};
        System.out.println(Arrays.toString(arr));

        rearrange(arr);

        System.out.println(Arrays.toString(arr));
    }
}