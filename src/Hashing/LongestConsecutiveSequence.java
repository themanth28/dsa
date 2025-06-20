package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> integerSet = new HashSet<>();

        int maxLength = 0;

        for(int n : nums){
            integerSet.add(n);
        }

        for(int n: nums){
            if(!integerSet.contains(n-1)){
                int currentNum = n;
                int len = 1;

                while (integerSet.contains(currentNum+1)){
                    currentNum++;
                    len++;
                }
                maxLength = Math.max(maxLength,len);
            }

        }

        return maxLength;
    }
}
