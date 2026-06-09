package Recursion;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.0000, 10));
    }

    public static double myPow(double x, int n) {
        if(n<0){
            if(n==Integer.MIN_VALUE){
                x=1/x;
                n = Integer.MAX_VALUE;
                return x * myPow(x,n);
            }
            x=1/x;
            n=-n;
        }

        return fastPow(x,n);
    }

    public static double fastPow(double x, int n){
        if(n==0){
            return 1.0;
        }

        double half = fastPow(x, n/2);
        if(n%2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}
