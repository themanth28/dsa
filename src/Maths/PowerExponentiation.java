package Maths;

public class PowerExponentiation {
    public static void main(String[] args) {
        int n = 2;
        int x = -2;
        System.out.println(Math.pow(n,x));
        System.out.println(power(n,x));
    }

    static double power(int n, int x){
        int m = x;
        x = Math.abs(x);
        double ans = 1;
        while (x>0){
            if(x%2 == 1){
                ans *= n;
                x -= 1;
            }else {
                x /= 2;
                n *= n;
            }
        }
        return m < 0? 1/ans : ans;
    }
}
