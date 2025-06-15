package StringProblem;

public class PrintPower {
    public static void main(String[] args) {
        int a = 4;
        System.out.println(printPower(a));
    }

    private static long printPower(int a) {
        if(a%10 == 1 || a%10 == 0){
            return a;
        }
        long ab = printPower(a-1);
        return a;
    }
}
