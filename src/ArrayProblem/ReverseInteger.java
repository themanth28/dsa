package ArrayProblem;

public class ReverseInteger {
    public static void main(String[] args) {
        int n = 1534236469;
        System.out.println(reverse(n));
    }
    static int reverse(int x) {
        if(Integer.MIN_VALUE >= x && x >= Integer.MAX_VALUE ){
            return 0;
        }
        boolean neg = false;
        if(x<0){
            x = -1 * x;
            neg = true;
        }
        String str = Integer.toString(x);
        char[] ans = new char[str.length()];
        for (int i=0; i<str.length(); i++){
            ans[i] = str.charAt(str.length()-1-i);
        }
        str = new String(ans);
        if(neg){
            return -1 * Integer.parseInt(str);
        }
        return Integer.parseInt(str);

    }
}
