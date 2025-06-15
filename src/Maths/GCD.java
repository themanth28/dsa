package Maths;

//Euclidean Algorithm
public class GCD {
    public static void main(String[] args) {
        int a = 12;
        int b = 9;
        System.out.println(gcd(a,b));
    }
    public static int gcd(int a, int b){
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
        if(a==0){
            return b;
        }else {
            return a;
        }
    }

}
