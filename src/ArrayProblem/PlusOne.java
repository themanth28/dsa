package ArrayProblem;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {

        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(plusOne(input)));
    }
    static int[] plusOne(int[] digits) {
        long result = 0;
        for (int digit : digits) {
            result = result * 10 + digit;
        }
        result = result+1;
        System.out.println(result);
        return convertDigitsToArray(result);
    }

        static int[] convertDigitsToArray(long res){

            String numberStr = Long.toString(res);
            int[] ans = new int[numberStr.length()];
            // Convert each character in the string to an integer and store it in the array
            for (int i = 0; i < numberStr.length(); i++) {
                ans[i] = numberStr.charAt(i) - '0';  // Subtract '0' to convert char to int
            }

        return ans;
        }
    }
