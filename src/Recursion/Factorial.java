package Recursion;

import java.util.ArrayList;

class Factorial {
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> result = new ArrayList<>();
        factorialHelper(n, 1, 1, result);
        return result;
    }

    static void factorialHelper(long n, long i, long fact, ArrayList<Long> result) {
        if (fact > n) {
            return;
        }
        result.add(fact);
        factorialHelper(n, i + 1, fact * (i + 1), result);
    }

    public static void main(String[] args) {
        long n = 100;
        ArrayList<Long> result = factorialNumbers(n);
        System.out.println(result);
    }
}