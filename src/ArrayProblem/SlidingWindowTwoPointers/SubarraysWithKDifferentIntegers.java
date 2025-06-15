package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        System.out.println(subArrays(arr,k) - subArrays(arr,k-1));
    }
    static int subArrays(int[] nums, int k){
        int left = 0, right = 0, n = nums.length, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while (right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while (map.size() > k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;

            right++;
        }
        return count;
    }
}
