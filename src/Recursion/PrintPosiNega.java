package Recursion;

public class PrintPosiNega {
    public static void main(String[] args) {
        int a = 25;
        printNum(a);
    }

    static void printNum(int n){
        if(n<0){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNum(n-5);
        System.out.println(n);
    }
}
