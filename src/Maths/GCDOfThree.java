package Maths;

import java.util.Scanner;

public class GCDOfThree {

    /**
     * Calculates the Greatest Common Divisor (GCD) of two numbers using the Euclidean algorithm.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The GCD of a and b.
     */
    public static long gcd(long a, long b) {
        // Handle negative numbers by taking their absolute value.
        a = Math.abs(a);
        b = Math.abs(b);
        
        // The Euclidean algorithm continues until b becomes 0.
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the first number:");
            long num1 = scanner.nextLong();

            System.out.println("Enter the second number:");
            long num2 = scanner.nextLong();

            System.out.println("Enter the third number:");
            long num3 = scanner.nextLong();

            // The GCD of three numbers is found by nesting the GCD function.
            // GCD(a, b, c) = GCD(GCD(a, b), c)
            long result = gcd(gcd(num1, num2), num3);

            System.out.println("The GCD of " + num1 + ", " + num2 + ", and " + num3 + " is: " + result);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }
}