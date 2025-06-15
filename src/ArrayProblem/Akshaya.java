package ArrayProblem;

public class Akshaya {

    public static void main(String[] args) {

        System.out.println(10%4);
        System.out.println(lastIndex(6,2));

    }

     static int lastIndex(int a, int b){

        if(b==0 || b==1){
            return a;
        }else {
            if(b==2){
                return a*a;
            } else if (b==3) {

            }
        }

        return a*(b+1);
     }
}
