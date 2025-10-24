package ProblemSolving.Arrays;

public class PositiveProductSubarray {

    public static int getMaxLen(int[] nums) {
        int maxLen = 0;
        int positiveLen = 0;
        int negativeLen = 0;

        for (int num : nums) {
            if (num == 0) {
                positiveLen = 0;
                negativeLen = 0;
            } else if (num > 0) {
                positiveLen += 1;
                negativeLen = (negativeLen > 0) ? negativeLen + 1 : 0;
            } else { // num < 0
                int temp = positiveLen;
                positiveLen = (negativeLen > 0) ? negativeLen + 1 : 0;
                negativeLen = temp + 1;
            }

            maxLen = Math.max(maxLen, positiveLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1, -2, -3, 4};
        int[] arr2 = {0, 1, -2, -3, -4};
//        int[] arr3 = {-1, -2, -3, 0, 1};

//        System.out.println(getMaxLen(arr1)); // Output: 4
        System.out.println(getMaxLen(arr2)); // Output: 3
//        System.out.println(getMaxLen(arr3)); // Output: 2
    }
}
