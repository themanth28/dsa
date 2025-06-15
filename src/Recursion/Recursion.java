package Recursion;

//https://tally.so/r/nGbMA2

public class Recursion {
    static int sum = 0;
    static int i = 200;

    public static void main(String[] args) {
        print();
    }

    static void print(){
        System.out.println(i);
        sum += i;
        i--;
        if(i<1){
            System.out.println("Sum = " + sum);
            return;
        }
        print();
    }
}