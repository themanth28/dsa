package BitManipulation;

import java.util.Arrays;

import static Recursion.ReverseNumber.reverseArrayFor;

public class FlippingAnImage {
    public static void main(String[] args) {
//        int[][] image = {
//                {1, 1, 0, 0},
//                {1, 0, 0, 1},
//                {0, 1, 1, 1},
//                {1, 0, 1, 0}
//        };
        int[][] image = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    static int[][] flipAndInvertImage(int[][] image) {

        for(int[] row : image){
            for(int i=0; i<(image.length+1)/2; i++){
                int temp = row[i] ^ 1;
                row[i] = row[image.length-1-i] ^ 1;
                row[image.length-1-i] = temp;
            }
        }

        return image;
    }
}
