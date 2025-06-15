package ArrayProblem;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {

    public static void main(String[] args) {
        int[] arr= {1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
//        set.add(nums[0]);
        for(int i : nums){
            if(set.contains(i))
                return true;
            set.add(i);
        }

        return false;
    }
}
