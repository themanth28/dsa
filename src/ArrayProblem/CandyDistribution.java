package ArrayProblem;

import java.util.Arrays;

public class CandyDistribution {
    
    public static int candy(int[] A) {
        int n = A.length;
        if (n == 0) return 0;

        // Step 1: Create a candies array where each child gets 1 candy initially.
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Step 2: First pass (left to right)
        // Ensure children with higher A than their left neighbor get more candies.
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Second pass (right to left)
        // Ensure children with higher A than their right neighbor get more candies.
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Calculate the total number of candies.
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,3,4,5};
        int result = candy(ratings);
        System.out.println("Total Candies: " + result);  // Expected Output: 6
    }
}
