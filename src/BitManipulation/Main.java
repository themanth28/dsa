package BitManipulation;

public class Main {
    public static void main(String[] args) {
        int a = 5;    // 0101 in binary
        int b = 3;    // 0011 in binary
//        int result = a ^ b ^ 6 ^ a ^ b;  // 0110 in binary => 6
        int result = a ^ a;
        System.out.println(8);
        System.out.println("Result of a ^ b: " + result);
    }
}
