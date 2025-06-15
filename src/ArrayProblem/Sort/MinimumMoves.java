package ArrayProblem.Sort;

import java.util.Arrays;

class MinimumMoves {
    public static void main(String[] args) {
        int[] seat = {3,20,17,2,12,15,17,4,15,20};
        int[] stu = {10,13,14,15,5,2,3,14,3,18};
        System.out.println(minMovesToSeat(seat,stu));
    }
    static int minMovesToSeat(int[] seats, int[] students) {
        swap(seats);
        swap(students);
        Arrays.sort(seats);
        System.out.println(Arrays.toString(seats));
        System.out.println(Arrays.toString(students));
        int sum = 0;
        for(int i=0; i<seats.length; i++){
            int k = seats[i] - students[i];
            if(k<0){
                k *= -1;
            }
            sum += k;
        }
        return sum;
    }

    static void swap(int[] arr){
        for(int i=0; i<arr.length; i++){
            boolean swapped = false;
            for(int j=1; j<arr.length-i;j++){
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }
}