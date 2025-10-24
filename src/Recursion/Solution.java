package Recursion;

class Solution {
    public static double myPow(double x, int n) {
        // Handle negative exponent
        if (n < 0) {
            // Check if n is Integer.MIN_VALUE to avoid stack overflow
            if (n == Integer.MIN_VALUE) {
                x = 1/x;
                n = Integer.MAX_VALUE;
                return x * myPow(x, n);
            }
            x = 1 / x;
            n = -n;
        }
        
        return fastPow(x, n);
    }
    
    private static double fastPow(double x, int n) {
        // Base case: x^0 = 1
        if (n == 0) {
            return 1.0;
        }

        // Recursive step: solve for n/2
        double half = fastPow(x, n / 2);

        // Check if n is even or odd
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }
}