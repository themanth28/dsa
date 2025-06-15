package BitManipulation;

//https://leetcode.com/problems/sum-of-two-integers/
public class SumWithoutOperator {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        while (b != 0) {
            int tmp = (a & b) << 1; // carry calculation
            a = a ^ b; // sum without carry
            b = tmp; // carry shifted left
            System.out.println(tmp + " tmp " + a + " a "+ b + " b");
        }
        System.out.println(a);
    }
}
