package Maths;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 42;
        int c = 0;
        for(int i=1; i<Math.sqrt(n); i++){
            if(n%i == 0){
                c+=1;
                System.out.println(i);
                if(n/i!=i){
                    c+=1;
                    System.out.println(n/i);
                }
            }
        }
        if(c==2){
            System.out.println("Prime");
        }else {
            System.out.println("Not Prime");
        }
    }
}
