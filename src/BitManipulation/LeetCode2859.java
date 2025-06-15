package BitManipulation;

//https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/?envType=problem-list-v2&envId=bit-manipulation

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeetCode2859 {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1,2,4,1,9,7,7,6);
        int k = 3;
        System.out.println(sumIndicesWithKSetBits(arr,k));

    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int baseValue = (int) Math.pow(2,k) - 1;
        int lastValue = (int) Math.pow(2,k+1) - 1;
        int sum = 0;
        int base = 4;
        int n = nums.size();
        for (int i=0; i<n; i++){

//            if(i >= baseValue && i < lastValue){
//                sum += nums.get(i);
//            }
//            if(k==1 && i == base){
//                sum += nums.get(i);
//            }else if(k!=1 && i == base){
//                sum -= nums.get(i);
//            }
        }
        return sum;
    }
}
