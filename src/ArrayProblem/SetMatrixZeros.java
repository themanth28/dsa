package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution(matrix);
    }

    public static void solution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> mlist = new ArrayList<>();
        List<Integer> nlist = new ArrayList<>();
        boolean rFlag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
//                    mlist.add(i);
                    nlist.add(j);
                    rFlag = true;
                }
            }
            if (rFlag) {
                Arrays.fill(matrix[i], 0);
            }
            for (int j=0; j<n; j++){
                if(nlist.contains(j)){
                    matrix[i][j] = 0;
                }
            }
            rFlag = false;
        }

        System.out.println(mlist + " " + nlist);

//        for (int i = 0; i < m; i++) {
//            if (mlist.contains(i)) {
//                Arrays.fill(matrix[i], 0);
//            }
//            for (int j=0; j<n; j++){
//                if(nlist.contains(j)){
//                    matrix[i][j] = 0;
//                }
//            }
//        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

