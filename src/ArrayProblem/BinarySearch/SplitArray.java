package ArrayProblem.BinarySearch;

//https://leetcode.com/problems/split-array-largest-sum/

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {31,14,19,75};
        int k = 2;
        System.out.println(splitArray(arr,k));
    }
    static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for (int j : nums) {
            start = Math.max(start, j); // in the end of the loop this will contain the max item of the array
            end += j;
        }
        while (start < end) {
            // try for the middle as potential ans
            int mid = start + (end - start) / 2;
            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int num : nums) {
                if (sum + num > mid) {
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
            System.out.println("mid "+mid);
            System.out.println("start "+start);
            System.out.println("sum "+sum);
            System.out.println("end "+end);
            System.out.println();

        }
        return end; // here start == end
    }
}
