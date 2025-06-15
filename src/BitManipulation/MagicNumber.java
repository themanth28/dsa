package BitManipulation;

public class MagicNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(magicNo(n));
    }

    static int magicNo(int n){
        int ans = 0;
        int base = 10;
        while (n > 0){
            int last = n & 1;
            System.out.println("last = n & 1: " + last);
            n = n >> 1;
            System.out.println("n = n >> 1: " + n);
            ans += last * base;
            System.out.println("  ans: " + ans);
            base *= 5;
        }
        return ans;
    }
}
