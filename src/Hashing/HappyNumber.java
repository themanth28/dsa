package Hashing;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(1111111));
    }

    public static boolean isHappy(int n) {
        int sum = 0;
        boolean yes = false;
        while(!yes){
            while (n>0){
                int a = n%10;
                sum += (a*a);
                n /= 10;
            }
            if(sum<10){
                yes = true;
            }else {
                n = sum;
                sum = 0;
            }
        }
        return sum == 1;
    }
}
