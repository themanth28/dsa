package ArrayProblem;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {3,12};
        int k = 1;
        System.out.println(missingNumber(arr,k));
    }

    static int missingNumber(int[] arr,int k){

        int count = 0;
        int prev = 0;
        int n = arr.length;
        for (int j : arr) {
            int gap = j - prev - 1;

            if (count + gap >= k) {
                return prev + (k - count);
            }
            count += gap;
            prev = j;
        }

        return arr[n-1] + (k - count);
    }
}
