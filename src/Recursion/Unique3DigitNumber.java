package Recursion;

public class Unique3DigitNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(totalNumbers(arr));
    }
    public static int totalNumbers(int[] digits) {
        int a = 0;
        return total(digits,a);
    }

    private static int total(int[] digits, int a) {
            
        return a + total(digits,a);
    }
}
