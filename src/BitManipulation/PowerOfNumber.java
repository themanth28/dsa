package BitManipulation;

public class PowerOfNumber {
    public static void main(String[] args) {
        int number = 2;
        int power = 6;
        int ans  = 1;
        while (power > 0){
            if( (power & 1) != 0 ){
                ans *= number;
            }
            power >>= 1;
            number *= number;
        }
        System.out.println("Answer: " + ans);
    }
}
