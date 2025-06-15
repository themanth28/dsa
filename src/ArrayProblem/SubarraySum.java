package ArrayProblem;

import java.util.*;

public class SubarraySum {

    public static int[] findSubarrayWithTargetSum(int[] arr, int target) {
        int left = 0;           // Left pointer of the window
        int currentSum = 0;     // Sum of the current window
        
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right]; // Add the current element to the sum
            
            // While the current sum exceeds the target, shrink the window from the left
            // But keep this inside the same loop
            if (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            // If we find the sum equal to target, return the 1-based indices
            if (currentSum == target) {
                return new int[]{left + 1, right + 1}; // Convert to 1-based index
            }
        }

        // If no subarray is found, return [-1]
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int[] arr = {19 ,23, 15, 6, 6, 2, 28, 2};
        int target = 2;

        int[] result = findSubarrayWithTargetSum(arr, target);
        
        System.out.println(Arrays.toString(result));
    }
}
