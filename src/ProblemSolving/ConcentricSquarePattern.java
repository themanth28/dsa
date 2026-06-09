package ProblemSolving;

public class ConcentricSquarePattern {

    /**
     * Prints the concentric square pattern for a given even number n.
     *
     * @param n The even size of the square matrix.
     */
    public static void printPattern(int n) {
        if (n <= 0 || n % 2 != 0) {
            System.out.println("Input must be a positive even number.");
            return;
        }

        System.out.println("Pattern for n = " + n + ":");

        // Outer loop for rows (r), from 1 to n
        for (int r = 1; r <= n; r++) {
            // Inner loop for columns (c), from 1 to n
            for (int c = 1; c <= n; c++) {
                
                // 1. Calculate the distance from the nearest edge.
                // Distance to top: r
                // Distance to bottom: n - r + 1
                int dist_row = Math.min(r, n - r + 1);
                
                // Distance to left: c
                // Distance to right: n - c + 1
                int dist_col = Math.min(c, n - c + 1);

                // d(r, c) is the minimum of all four edge distances.
                int min_distance = Math.min(dist_row, dist_col);

                // 2. Calculate the value based on the distance.
                // The outermost frame (min_distance = 1) must have value n.
                // The innermost frame (min_distance = n/2) must have value n - (n/2) + 1.
                int value = n - min_distance + 1;

                // Print the value. Use printf for consistent spacing.
                System.out.printf("%d", value);
            }
            // Move to the next line after finishing a row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example 1: n = 4
        printPattern(4);
        /* Expected Output:
        4444
        4334
        4334
        4444
        */

        System.out.println();

        // Example 2: n = 6
        printPattern(8);
        /*
        Expected Output:
        666666
        655556
        654456
        654456
        655556
        666666
        */
    }
}