package ArrayProblem;

public class FindPermutatedOrNot {

    // Method to check if two arrays are permutations of each other
    public static boolean areArraysPermutations(int[] arr1, int[] arr2) {
        // If the arrays have different lengths, they cannot be permutations
        if (arr1.length != arr2.length) {
            return false;
        }

        // Assuming elements in the array are within a fixed range
        // For example, let's assume the values are between 0 and 1000.
        // If the input is different, adjust the size accordingly.
        int[] frequency = new int[1001];  // Frequency array for elements from 0 to 1000

        // Count the frequency of elements in arr1
        for (int num : arr1) {
            frequency[num]++;
            System.out.println(frequency[num]);
        }

        // Check the frequency of elements in arr2
        for (int num : arr2) {
            if (frequency[num] == 0) {
                return false;  // Element in arr2 doesn't exist in arr1 or mismatch in count
            }
            frequency[num]--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        int[] input1 = {1, 2, 3, 0, 0};
        int[] input2 = {2, 1, 3, 0, 0};
        System.out.println(areArraysPermutations(input1, input2));  // Output: true

        int[] input3 = {4, 3, 6, 7, 2};
        int[] input4 = {2, 6, 4, 7, 3};
//        System.out.println(areArraysPermutations(input3, input4));  // Output: true

        int[] input5 = {1, 4, 5};
        int[] input6 = {1, 4, 6};
//        System.out.println(areArraysPermutations(input5, input6));  // Output: false
    }
}
