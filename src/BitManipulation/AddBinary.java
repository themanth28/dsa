package BitManipulation;


//https://leetcode.com/problems/add-binary/description/?envType=problem-list-v2&envId=bit-manipulation
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop through both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;  // Start with the carry

            // Add bit from a if available
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int ('0' = 0, '1' = 1)
            }

            // Add bit from b if available
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // Append the current bit (sum % 2) to the result
            result.append(sum % 2);

            // Calculate carry (sum / 2)
            carry = sum / 2;
        }

        // The result is built backwards, so reverse it before returning
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1011";  // 11 in decimal
        String b = "110";   // 6 in decimal

        System.out.println("Sum: " + addBinary(a, b));  // Output: 10001
    }
}
