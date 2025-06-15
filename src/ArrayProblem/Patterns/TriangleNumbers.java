package ArrayProblem.Patterns;

public class TriangleNumbers {
    public static void main(String[] args) {
        int n =7;
//        triangleNumber(n);
        String s = "geeks";
        printCross(s);
    }

    static void printCross(String str){
        for(int i=1; i<=str.length(); i++){
            for (int j=str.length(); j>=1; j--){
                if(Math.abs(i-j) == str.length()-i){
                    System.out.print(str.charAt(j-1));
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    static void triangle(int n) {
        for(int i=0; i<=n; i++){
            for(int j=n; j>i; j--){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }

//1
//2 2
//3 3 3
//4 4 4 4
//5 5 5 5 5

//    5 13 2 7 6 8 1

    static void triangleNumber(int n){
        for(int i=1; i<=n; i++){
            int num = 0;
            int sum = 0;
            for(int j=1; j<=i; j++){
                System.out.print(i+sum+" ");
                num++;
                sum = sum+(n-num);
            }
            System.out.println();
        }
    }
}
