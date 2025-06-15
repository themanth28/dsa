package ArrayProblem;

public class LastDigit {
    public static void main(String[] args) {
        String a = "999";  // Base is 999
        String b = "999";  // Exponent is 999

        System.out.println(lastDigit(a, b)); // Output the last digit of a^b
    }

    public static int lastDigit(String a, String b) {
        // Step 1: Get the last digit of a
        int base = Integer.parseInt(a) % 10;  // Last digit of base (999 % 10 = 9)

        // Step 2: Find the cycle of last digits for powers of base
        int[] cycle = getCycle(base);

        // Step 3: Calculate the effective exponent (b % cycle.length)
        int exp = getEffectiveExponent(b, cycle.length);

        // Step 4: Return the correct last digit from the cycle
        if (exp == 0) {
            return cycle[cycle.length - 1];  // If exponent mod cycle length is 0, use the last element in the cycle
        }
        return cycle[exp - 1];  // Otherwise, use the reduced exponent
    }

    // Find the cycle of last digits for powers of a base
    private static int[] getCycle(int base) {
        int[] cycle = new int[4];  // Max cycle length for mod 10 is 4
        int current = base;
        for (int i = 0; i < 4; i++) {
            cycle[i] = current;
            current = (current * base) % 10;
            if (current == cycle[0]) {
                break;
            }
        }
        return java.util.Arrays.copyOfRange(cycle, 0, 4);
    }

    // Reduce b using modulo with the cycle length
    private static int getEffectiveExponent(String b, int cycleLength) {
        int exp = 0;
        for (char digit : b.toCharArray()) {
            exp = (exp * 10 + (digit - '0')) % cycleLength;
        }
        return exp == 0 ? cycleLength : exp;
    }
}
