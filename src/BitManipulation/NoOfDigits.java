package BitManipulation;

public class NoOfDigits {
    public static void main(String[] args) {
        int n = 8;
        int b = 2;
        System.out.println(Math.log(n) +" " + Math.log(b));
        int ans = (int) (Math.log(n) / Math.log(b)) + 1;
        System.out.println( "Number of digits: "+ ans);
    }
}
