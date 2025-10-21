package ProblemSolving;

public class NumberContainsNumeric {
    public static boolean isPresent(int a, int b) {
        int lenA = 0;
        int tempA = a;
        while (tempA > 0) { // count digits in a
            lenA++;
            tempA /= 10;
        }
        System.out.println(lenA);

        int div = (int) Math.pow(10, lenA); // divisor for extracting subnumbers
        int tempB = b;

        System.out.println(div);

        while (tempB >= a) {
            int sub = tempB % div; // last lenA digits
            System.out.println(sub);
            if (sub == a) return true;
            tempB /= 10; // move one digit left
        }

        return false;
    }

    public static void main(String[] args) {
        int a = 23;
        int b = 12345;
        System.out.println(isPresent(a, b)); // true

//        a = 56;
//        b = 12345;
//        System.out.println(isPresent(a, b)); // false
    }
}
