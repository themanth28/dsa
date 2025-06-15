package ArrayProblem;

public class NumberCount {

    // Function to calculate the sum of digits of a number
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Function to count numbers satisfying the condition
    public static int countNumbers(int N, int diff) {
        int count = 0;

        // Iterate through all numbers less than N
        for (int x = diff; x < N; x++) {
            int sumDigits = sumOfDigits(x);
            if (x - sumDigits >= diff) {
                count++;
            }
        }
        return count + 1;
    }

    // Function to test the behavior based on the pattern observed
    public static void testPattern() {
        int diff = 70;

        // Test the logic on different ranges
        System.out.println("For N = 10, diff = " + diff + " => Count: " + countNumbers(87, diff));  // Expected: 9
//        System.out.println("For N = 20, diff = " + diff + " => Count: " + countNumbers(20, diff));  // Expected: 18
//        System.out.println("For N = 100, diff = " + diff + " => Count: " + countNumbers(100, diff)); // Expected: 11
//        System.out.println("For N = 110, diff = " + diff + " => Count: " + countNumbers(110, diff)); // Expected: 12
//        System.out.println("For N = 1000, diff = " + diff + " => Count: " + countNumbers(1000, diff)); // Expected: 111
    }

    public static void main(String[] args) {
        testPattern();
    }
}
