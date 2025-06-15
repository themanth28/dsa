package ArrayProblem;

import java.util.Arrays;

public class AddLeastPrimeNumber {
    public static void main(String[] args) {
        long[] arr1 = {20, 30, 40};
        long[] arr2 = {7, 11, 13};
        System.out.println(Arrays.toString(leastPrimeNumber(arr1, arr2)));
    }

    static long[] leastPrimeNumber(long[] arr1, long[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            long n = arr1[i] % arr2[i];
            if (n != 0) {
                long prime = arr2[i] - n;
                while (!isPrime(prime)) {
                    prime++;
                }
                arr1[i] = prime;
            }
        }
        return arr1;
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
