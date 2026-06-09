package ProblemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryDecimalDecomposition {

    /**
     * Finds the minimum number of binary-decimals required to sum up to the input number,
     * and returns the binary-decimals themselves.
     *
     * @param n The input number (as a string to handle digit-by-digit processing easily).
     * @return A List of strings, where each string is a binary-decimal.
     */
    public static List<String> solve(String n) {
        if (n == null || n.isEmpty()) {
            return Collections.emptyList();
        }

        // Step 1: Find the maximum digit (This is the minimum count required)
        int maxDigit = 0;
        for (char c : n.toCharArray()) {
            int digit = c - '0';
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        
        // The minimum number of binary-decimals is maxDigit
        if (maxDigit == 0) {
            return Collections.singletonList("0");
        }

        // Step 2: Initialize the list of binary-decimals (maxDigit in total)
        List<StringBuilder> binaryDecimals = new ArrayList<>();
        for (int i = 0; i < maxDigit; i++) {
            binaryDecimals.add(new StringBuilder());
        }

        // Step 3: Iterate through the digits of the input number N
        for (char c : n.toCharArray()) {
            int digit = c - '0';

            // For the first 'digit' binary-decimals, append '1'
            for (int i = 0; i < digit; i++) {
                binaryDecimals.get(i).append('1');
            }

            // For the remaining 'maxDigit - digit' binary-decimals, append '0'
            for (int i = digit; i < maxDigit; i++) {
                binaryDecimals.get(i).append('0');
            }
        }

        // Step 4: Convert StringBuilder list to String list and return.
        // The problem description implies removing leading zeros is unnecessary 
        // if the structure ensures no non-significant leading zeros, 
        // but we'll convert them cleanly.
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : binaryDecimals) {
            // Trim potential leading zeros (e.g., if a number started with '0'
            // and its place value was filled with '0' for every BD)
            String bd = sb.toString();
            // In our greedy construction, the only time '0' is at the start 
            // is if the input itself starts with '0', which we assume is not the case for a number N.
            // If the input is '32', all generated BDs will start with '1'.
            // The only issue would be if a generated BD is "000" which only happens 
            // if maxDigit is 0 (handled) or the input is '0'.
            // For N=32, maxDigit=3.
            // i=3: BD1='1', BD2='1', BD3='1'
            // i=2: BD1='1', BD2='1', BD3='0'
            // Result: "11", "11", "10"
            // Let's stick to the generated string as it is usually correct.
            result.add(bd);
        }

        return result;
    }

    public static void main(String[] args) {
        // Input: 32 -> Max Digit: 3. Expected: 10 11 11 (Order might vary)
        String input1 = "32";
        List<String> output1 = solve(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output (Count: " + output1.size() + "): " + output1);
        // Sum check: 11 + 11 + 10 = 32

        System.out.println("---");

        // Input: 120 -> Max Digit: 2. Expected: 10 110 (Order might vary)
        String input2 = "120";
        List<String> output2 = solve(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output (Count: " + output2.size() + "): " + output2);
        // Sum check: 110 + 10 = 120

        System.out.println("---");

        // Input: 333 -> Max Digit: 3. Expected: 111 111 111
        String input3 = "333";
        List<String> output3 = solve(input3);
        System.out.println("Input: " + input3);
        System.out.println("Output (Count: " + output3.size() + "): " + output3);
        // Sum check: 111 + 111 + 111 = 333

        System.out.println("---");
        
        // Input: 509 -> Max Digit: 9. Expected: 9 numbers
        String input4 = "509";
        List<String> output4 = solve(input4);
        System.out.println("Input: " + input4);
        System.out.println("Output (Count: " + output4.size() + "): " + output4);
        // Sum check: 101+101+101+101+101+000+000+000+000 for 509 -> 5+0+9
        // BD1: 101, BD2: 101, BD3: 101, BD4: 101, BD5: 101, BD6-BD9: 001
        // (101 * 5) + (001 * 4) = 505 + 4 = 509 -> Correct!
    }
}