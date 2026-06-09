package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int i = 0;
        System.out.println(forFibo(n));
//        while (i<n) {
//            System.out.println(fiboFormula(i));
//            System.out.println(fibo(i));
//            i++;
//        }
//        System.out.println(fiboFormula(n));
    }

    static int fiboFormula(int n){
        return (int)(Math.pow((1+Math.sqrt(5))/2, n) / Math.sqrt(5));
    }

    static int forFibo(int n){
        int a = 1;
        int b = 1;
        for (int i=1; i<n; i++){
            b = b+a;
            a = b-a;
        }
        return a;
    }

    static int fibo(int n) {
        if(n<2){
            return n;
        }
        int a = fibo(n-1);
        int b = fibo(n-2);
        return a+b;
    }
}