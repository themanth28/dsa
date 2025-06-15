package ArrayProblem;

public class MissingNumber {

    public static void main(String[] args) {
        int [] arr = {1,2,3,5};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr) {
        // code here
        int sum = 0;
        int sum1 = 0;
        for(int i=0; i<=arr.length+1;i++){
            if(i<arr.length){
                sum = sum + arr[i];
            }
            sum1 = sum1 + i;
        }
        System.out.println(sum1);
        System.out.println(sum);
        return sum1 - sum;
    }
}
