package ArrayProblem;

class SumOfDivisors {

    public static void main(String[] args) {
        System.out.println(sumOfDivisors(7));
    }
    public static int sumOfDivisors(int n) {
//        // code here
//        int sum =n + ((n * (n+1)) / 2) - 1;
//        System.out.println(sum);
//        for(int i=2; i<=n-1; i++){
//            for(int j=2; j<=n-1; j++){
//                if(i%j == 0){
//                    sum += j;
//                }
//            }
//        }

        int sum =0;
        for(int i=1; i<=n; i++){
            System.out.println((n/i)*i);
            sum +=(n/i)*i;
            System.out.println("sum "+sum);
        }
        return sum;
    }
}