package Maths;

import java.util.Scanner;

public class LCMCalculator {

    // A recursive method to find the GCD of two numbers
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // A method to find the LCM of two numbers
    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }

    // A method to find the LCM of three numbers
    public static long lcmOfThreeNumbers(long a, long b, long c) {
        return lcm(lcm(a, b), c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers:");
        long num1 = scanner.nextLong();
        long num2 = scanner.nextLong();
        long num3 = scanner.nextLong();

        long result = lcmOfThreeNumbers(num1, num2, num3);
        System.out.println("The LCM of " + num1 + ", " + num2 + ", and " + num3 + " is: " + result);

        scanner.close();
    }
}