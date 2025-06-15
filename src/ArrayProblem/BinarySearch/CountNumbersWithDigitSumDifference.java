package ArrayProblem.BinarySearch;

public class CountNumbersWithDigitSumDifference {
    public static void main(String[] args) {
        int n = 13;
        int k = 2;
        System.out.println(sumDifference(n,k));
        System.out.println(10%10);
        System.out.println(132/10);
    }

    static int sumDifference(int n, int k){
        int N = n;
        int mod = n % 10;
//        int div = n / 10;
        int count = 1;
        while(n<10){
            n = n/10;
            count++;
        }

        return 0;
    }
}

