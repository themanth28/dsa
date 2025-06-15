package Recursion;

public class PowerOfThree {
    public static void main(String[] args) {
        int a = 45;
        System.out.println(isPowerOfThree(a));
    }
    public static boolean isPowerOfThree(int n) {
        if(n==1){
            return false;
        }
        return isPowerOfThree(n/3);
    }
}
