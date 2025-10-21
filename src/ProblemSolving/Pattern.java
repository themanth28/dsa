package ProblemSolving;

public class Pattern {
    public static void main(String[] args) {
//        diamond(5);
//        pattern3(5);
//        pattern11(5);
//        pattern12(4);
        pattern13(5);
    }



    public static void pattern13(int n){
        int sup = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(sup+j + " ");
            }
            sup+=i;
            System.out.println();
        }
    }

    public static void pattern12(int n){
        for (int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            for (int j=2*(n-i); j>=1; j--){
                System.out.print("  ");
            }
            for (int j=i; j>=1; j--){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if((i+j)%2 ==0){
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }
//                if(i%2==1){
//                    if(j%2==0){
//                        System.out.print("0 ");
//                    }else {
//                        System.out.print("1 ");
//                    }
//                }else {
//                    if(j%2==0){
//                        System.out.print("1 ");
//                    }else {
//                        System.out.print("0 ");
//                    }
//                }
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void diamond(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
