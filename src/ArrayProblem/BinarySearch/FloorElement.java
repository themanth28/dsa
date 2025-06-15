package ArrayProblem.BinarySearch;

public class FloorElement {

    public static int findFloorIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int result = -1; // To store the index of the floor element

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If arr[mid] is equal to x, then arr[mid] is the floor
            if (arr[mid] == x) {
                result = mid;  // Found the target, but continue searching for the last occurrence
                right = mid - 1; // Search right to find the last occurrence of x
            }
            // If arr[mid] is less than or equal to x, it could be a candidate for floor
            else if (arr[mid] < x) {
//                result = mid; // update result
                left = mid + 1; // search in the right half
            }
            // If arr[mid] is greater than x, we need to search the left half
            else {
                result = mid;
                right = mid - 1;
            }
        }

        return result; // If no valid floor found, result will be -1
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {4, 15, 17, 17, 19, 20, 21, 22, 22, 25, 26, 26, 26, 28, 28, 28, 31, 31, 32, 33, 34, 34, 35, 36, 36, 37, 38, 38, 39, 41, 41, 42, 43, 43, 44, 44, 45, 45, 46, 47, 49, 49, 50, 50, 50, 51, 53, 54, 54, 56, 57, 58, 58, 59, 60, 64, 67, 69, 75, 94};
        int target = 26;

        int result = findFloorIndex(arr, target);

        System.out.println(result); // Output the result
    }
}
