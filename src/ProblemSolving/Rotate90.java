package ProblemSolving;

class Rotate90 {
    public static void rotateAntiClockwise(int[][] mat, int n) {
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        printMatrix(mat);
        System.out.println();

        // Step 2: Reverse each column
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n / 2; row++) {
                int temp = mat[row][col];
                mat[row][col] = mat[n - 1 - row][col];
                mat[n - 1 - row][col] = temp;
            }
        }

    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = mat.length;
        printMatrix(mat);
        System.out.println();
        rotateAntiClockwise(mat, n);
        printMatrix(mat);
    }
}
