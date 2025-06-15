package ArrayProblem.BinarySearch;

public class CeilingNumber {

    public static void main(String[] args) {

        int[] arr = {2,3,4,6,14,16,18,19,87,190};
        int tar = 17;
        System.out.println(ceiling(arr,tar));
    }

    //return the next greatest number = ceiling
    //return the previous greatest number = floor

    static int ceiling(int[] arr, int tar){

        int start = 0;
        int end = arr.length;

        while (start<=end ){
            int mid = (start+end)/2;
            System.out.println("mid " + mid);
            if(arr[mid] == tar){
                return arr[mid];
            }
            if(arr[mid] < tar){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        return arr[start];
    }
}
