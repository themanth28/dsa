package ArrayProblem;

class CountDigits {

    public static void main(String[] args) {
        int n = 2446;
        System.out.println(n);
        System.out.println(evenlyDivides(n));
    }
    static int evenlyDivides(int n) {
        int count = 0;
        int N = n;
        // code here
        while(n>0){
            int a = n%10;
            if(a != 0 && N%a == 0){
                count++;
            }
            n = n/10;
        }
        return count;
    }
}