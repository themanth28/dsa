package StringProblem;

import java.util.Arrays;

public class NextGreaterNumber {
    public static int nextGreater(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        // Step 1: Find first decreasing digit from the right
        int i = n - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, no next permutation exists
        if (i < 0) {
            return -1; // No larger number possible
        }

        // Step 2: Find the smallest digit on the right side that is larger than digits[i]
        int j = n - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the found digits
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse the remaining right part
        reverse(digits, i + 1, n - 1);

        // Convert back to integer
        long nextNum = Long.parseLong(new String(digits));

        // Check for integer overflow (Java int max = 2,147,483,647)
        return (nextNum > Integer.MAX_VALUE) ? -1 : (int) nextNum;
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int num = 14382;
//        System.out.println("Next Greater Number: " + nextGreater(num)); // Output: 14823
//
        num = 43871;
        System.out.println("Next Greater Number: " + nextGreater(num)); // Output: 172

//        num = 172;
//        System.out.println("Next Greater Number: " + nextGreater(num)); // Output: 217

//        num = 999;
//        System.out.println("Next Greater Number: " + nextGreater(num)); // Output: -1 (No larger number possible)
    }
}
