package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationSequence {
    /**
     * Finds the kth permutation of the sequence [1, 2, 3, ..., n].
     *
     * @param n The number of elements in the set.
     * @param k The position of the permutation to find (1-indexed).
     * @return The kth permutation sequence as a string.
     */
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder result = new StringBuilder();

        // Precompute factorials and initialize the list of numbers.
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        System.out.println(Arrays.toString(factorial));
        System.out.println(numbers);

        // Adjust k to be 0-indexed for easier calculations.
        k--;

        // Iteratively build the permutation from left to right.
        for (int i = n; i > 0; i--) {
            // Determine the index of the digit to pick.
            // The number of permutations of the remaining i-1 digits is (i-1)!.
            int index = k / factorial[i - 1];

            // Append the selected digit to the result.
            result.append(numbers.get(index));

            // Remove the used digit from the list of available numbers.
            numbers.remove(index);

            // Update k for the next iteration by taking the remainder.
            k %= factorial[i - 1];
        }

        return result.toString();
    }

    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();

        // Example 1
        int n1 = 3;
        int k1 = 3;
//        System.out.println("n = " + n1 + ", k = " + k1 + " -> " + solution.getPermutation(n1, k1)); // Expected: 213

        // Example 2
        int n2 = 4;
        int k2 = 9;
        System.out.println("n = " + n2 + ", k = " + k2 + " -> " + solution.getPermutation(n2, k2)); // Expected: 2314

        // Example 3
        int n3 = 3;
        int k3 = 1;
        System.out.println("n = " + n3 + ", k = " + k3 + " -> " + solution.getPermutation(n3, k3)); // Expected: 123
    }
}