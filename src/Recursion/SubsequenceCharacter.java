package Recursion;

public class SubsequenceCharacter {
    static void generate(String input, String output, int index) {
        if (index == input.length()) {
            System.out.println(output); // Print a subsequence
            return;
        }

        // Include current character
        generate(input, output + input.charAt(index), index + 1);

        // Exclude current character
        generate(input, output, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        generate(str, "", 0);
    }
}
