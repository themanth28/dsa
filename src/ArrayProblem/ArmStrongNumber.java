package ArrayProblem;

class ArmStrongNumber {
    public static void main(String[] args) {
        System.out.println((10 * (10+1))/2);
        System.out.println(armstrongNumber(153));
    }
    static boolean armstrongNumber(int n) {
        // code here
        int N = n;
        int sum = 0;
        while(n != 0){
            int a = n%10;
            sum += a*a*a;
            n = n/10;
        }
        System.out.println(sum);
        if(sum == N){
            return true;
        }
        return false;
    }
}