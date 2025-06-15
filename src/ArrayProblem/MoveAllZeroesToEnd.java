package ArrayProblem;

import java.util.Arrays;

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {1,2,0,0,0,0,4,5};
        pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void pushZerosToEnd(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
            System.out.println(Arrays.toString(arr) + i + " " + count);
        }



//        int n = arr.length;
//        int j = 0;
//        for (int value : arr) {
//            if (value != 0) {
//                arr[j++] = value;
//            }
//        }
//
//        while (j < arr.length)
//            arr[j++] = 0;



//        System.arraycopy(temp, 0, arr, 0, n);
//        int count = 1;

//        for(int i=0; i<n-count; i++){
//            if(arr[i] == 0){
//                int first = arr[i];
//                for(int j = i; j<n-count; j++){
//                   arr[j] = arr[j+1];
//                }
//                arr[n-count] = first;
//                count++;
//            }
//        }

    }
}
