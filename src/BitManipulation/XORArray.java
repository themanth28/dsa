package BitManipulation;

public class XORArray {
    public static void main(String[] args) {
        int n = 9384;
        int start = 3;
        System.out.println(xorOperation(n,start));
    }
    public static int xorOperation(int n, int start) {
        long solution = start;
        for(int i=1 ; i<n; i++){
            solution ^= 2L *i + start;
        }
        return (int) solution;
    }
}
