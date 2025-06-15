package ArrayProblem.Patterns;

//https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/

public class Triangle {
    public static void main(String[] args) {
        int n = 5;
        pattern13(n);
    }

    static void pattern22(int n){
//        n = n-1;
        for(int i=1; i<2*n; i++){
            for (int j=1; j<2*n; j++){
                int atEveryIndex = n - Math.min(Math.min(i,j),Math.min(2*n-i,2*n-j)) +1;
                System.out.print(atEveryIndex+" ");
            }
            System.out.println();
        }
    }


    static void pattern21(int n){
        for (int i=1; i<=n; i++){
            if(i==1 || i==n){
                for (int j=1; j<=n; j++){
                    System.out.print("* ");
                }
            }else {
                System.out.print("* ");
                for (int j=1; j<=n-2; j++){
                    System.out.print("  ");
                }
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern13(int n){
        int num = 1;
        for (int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }

    static void pattern12(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j + " ");
            }
            for(int j=2*n-(2*i); j>0; j--){
                System.out.print("  ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern11(int n){
        for(int i=1; i<=n; i++){
            for (int j = 0; j < i; j++) {
                System.out.print((i+j) % 2 + " ");
            }
            System.out.println();
        }
    }

    static void pattern10(int n){
        for(int i=1; i<2*n; i++){
            int tc = i <= n ? i : 2*n - i;
            for (int j=1; j<=tc; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern9(int n){
        for (int i=1; i<=2*n; i++){
            int tc = 0;
            if(i<=n){
                tc = (2*i)-1;
            } else if (i == n+1) {
                tc = 2*n - 1;
            }else {
                tc = i - 0;
            }
//            for(int k=i; k<n; k++){
//                System.out.print("  ");
//            }
            for(int j=1; j<=tc; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern8(int n){
        for (int i=1; i<=n; i++){
            for(int k=1; k<2*i - i; k++){
                System.out.print("  ");
            }
            for(int j=(2*n)-(2*i)+1; j>=1; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for (int i=1; i<=n; i++){
            for(int k=i; k<n; k++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int i=1; i<=n; i++){
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    static void triangle(int n) {
        for(int i=0; i<=n; i++){
            for(int j=n; j>i; j--){
                System.out.print(j+ " " +i+j+" ");
            }
            System.out.println();
        }
    }

    static void pyramid(int n){
        int m = (n-1)*2 + 1;
        for(int i=0;i<n;i++){
            for(int j=n-1; j>0; j--){
                System.out.println(" ");
            }
            System.out.println();
        }
    }
}
