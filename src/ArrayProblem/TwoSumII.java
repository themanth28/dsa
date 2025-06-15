package ArrayProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {4,7,2,10,4,8};
        int tar = 14;
        System.out.println(result(arr,tar));
    }

    static ArrayList<Integer> result(int[] arr, int tar){
//        int sum = 0, count = 0;
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i=0; i<arr.length; i++){
//            sum += arr[i];
//            if(sum > tar){
//                sum -= arr[count];
//                count++;
//            }
//            if(sum == tar){
//                ans.add(count+1);
//                ans.add(i+1);
//                return ans;
//            }
//        }

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            int complement = tar - arr[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the 1-based index positions
                ans.add(map.get(complement) + 1); // 1-based index
                ans.add(i + 1);  // 1-based index
                return ans;
            }

            // If complement is not found, add the current number to the map
            map.put(arr[i], i);
        }


//        int left = 0, right = arr.length - 1;
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        while (left < right) {
//            int sum = arr[left] + arr[right];
//            if (sum == tar) {
//                // Return the 1-based index of the elements
//                ans.add(left + 1);
//                ans.add(right + 1);
//                return ans;
//            } else if (sum < tar) {
//                left++;
//            } else {
//                right--;
//            }
//        }
        return new ArrayList<>(Collections.singletonList(-1));
    }
}
