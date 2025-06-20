package ArrayProblem.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ArrayProblem.Sort.Sort.swap;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {5,4,6,3,3,1};
        System.out.println(Arrays.toString(cycleSort(nums)));;
    }

    static int[] cycleSort(int[] nums){
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums,i,correct);
                if(i+1 != nums[i] && !list.contains(nums[i])){
                    System.out.println("hhs "+nums[i]);
                    list.add(nums[i]);
                }
            }else{
                if(i+1 == nums[i] && list.contains(nums[i])){
                    list.remove(nums[i]);
                }
                i++;
            }
            System.out.println(Arrays.toString(nums) + " "+ i);
            System.out.println(list);
        }
        return nums;
    }
}
