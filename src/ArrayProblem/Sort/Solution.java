package ArrayProblem.Sort;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOdd(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void segregateEvenOdd(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return; // No-op for null or single-element arrays.
        }

        int left = 0;
        int right = arr.length - 1;

        // Partition the array into even (left side) and odd (right side) numbers
        while (left < right) {
            // Increment left pointer until an odd number is found
            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }

            // Decrement right pointer until an even number is found
            while (arr[right] % 2 != 0 && left < right) {
                right--;
            }

            // If left is still less than right, a swap is needed
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        // Now, the array is partitioned. The 'left' pointer (or 'right' + 1)
        // indicates the start of the odd number sub-array.
        int evenCount = 0;
        for (int x : arr) {
            if (x % 2 == 0) {
                evenCount++;
            }else {
                break;
            }
        }

        // Sort the even numbers (from index 0 to evenCount - 1)
        Arrays.sort(arr, 0, evenCount);

        // Sort the odd numbers (from index evenCount to the end)
        Arrays.sort(arr, evenCount, arr.length);
    }
}
