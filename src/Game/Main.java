package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static String[][] matrix = new String[6][7];
    public static List<Integer> list = new ArrayList<>();
    private static int iEle = 5;
    private static int countA = 0;
    private static int countB = 0;

    private static int i,j;

    public static void main(String[] args) {
        int i,j;
        for (i=0; i<6; i++){
            for (j=0; j<7; j++){
                matrix[i][j] = "O";
            }
        }
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            } System.out.println();
        }
        while (true) {
            if (Objects.equals(playerA(), "A")){
                System.out.println("PLAYER A WINS");
                break;}
            if (Objects.equals(playerB(), "B")){
                System.out.println("PLAYER B WINS");
                break;
            }

        }
    }

    public static String playerA() {
        countA++;
        System.out.println("Player A: ");
        Scanner scanner = new Scanner(System.in);
        int count = -1;
        int n = scanner.nextInt();
        list.add(n);
        for (int c = 0; c < list.size(); c++) {
            if (list.get(c) == n) {
                count++;
            }
        }
        matrix[iEle - count][n - 1] = "A";
        if (countA > 3) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;

            for (int z = 0; z < 4; z++) {
                if ((n-1)>2 && matrix[iEle -count][n -1 - z].equals("A")){
                    sum2 = sum2 + 1;
                }
                if ( matrix[iEle - z][n - 1].equals("A")) {
                    sum1 = sum1 + 1;
                }
                if ((iEle-count)<3 && (n-1)>2 && matrix[iEle-count+z][n-1-z].equals("A")){
                    sum3 = sum3 + 1;
                }
                if ((iEle-count)<3 && (n-1)<4 && matrix[iEle-count+z][n-1+z].equals("A")){
                    sum4 = sum4 + 1;
                }

            }
            if (sum1 == 4 || sum2 == 4 || sum3 == 4 || sum4 == 4) {
                return "A";
            }
        }
            for (i = 0; i < 6; i++) {
                for (j = 0; j < 7; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            return null;
        }


    public static String playerB(){
        countB++;
        System.out.println("Player B: ");
        Scanner scanner = new Scanner(System.in);
        int count = -1;
        int n = scanner.nextInt();
        list.add(n);
        for(int c=0;c<list.size();c++){
            if(list.get(c) == n){ count++; }
        }

        matrix[iEle-count][n-1] = "B";
        if (countB > 3) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;

            for (int z = 0; z < 4; z++) {
                if ((n-1)>2 && matrix[iEle -count][n -1 - z].equals("B")){
                    sum2 = sum2 + 1;
                }
                if ( matrix[iEle - z][n - 1].equals("B")) {
                    sum1 = sum1 + 1;
                }
                if ((iEle-count)<3 && (n-1)>2 && matrix[iEle-count+z][n-1-z].equals("B")){
                    sum3 = sum3 + 1;
                }
                if ((iEle-count)<3 && (n-1)<4 && matrix[iEle-count+z][n-1+z].equals("B")){
                    sum4 = sum4 + 1;
                }

            }
            if (sum1 == 4 || sum2 == 4 || sum3 == 4 || sum4 == 4) {
                return  "B";
            }
        }


        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            } System.out.println();
        }
        return null;
    }
}