package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] nums1 = {3,1,2};
        int[] nums2 = {1,1};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

    static int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m){
            int[] nums3 = nums2;
            nums2 = nums1;
            nums1 = nums3;
        }

        System.out.println("nums2"+Arrays.toString(nums2));
        System.out.println("nums1"+Arrays.toString(nums1));
        int count = 0;
        ArrayList<Integer> sol= new ArrayList<>();

        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    sol.add(k);
                    count++;
                    break;
                }
            }
        }
        int[] ans = new int[sol.size()];
        for(int i=0; i<sol.size();i++){
            ans[i] = sol.get(i);
        }
        return ans;
    }
}
