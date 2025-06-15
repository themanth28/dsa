package ArrayProblem;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] digitsArray = {9};
        System.out.println(Arrays.toString(plusOne(digitsArray)));
        int mid = 1/2;
        System.out.println("mid" +mid);
    }

    static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            System.out.println("i "+ i + "digits " + digits[i]);
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        System.out.println(newNumber[1]);
        return newNumber;
    }


}