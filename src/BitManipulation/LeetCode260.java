package BitManipulation;

import java.util.*;

public class LeetCode260 {
    public static void main(String[] args) {
        int[] arr = {8, 9, 8, 9, 7, 6};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    public static int[] singleNumber(int[] nums) {

        int ans =0 ;
        for (int num : nums) {
            ans = ans ^ num;
        }
        System.out.println(ans);
        ans = (ans & -ans);
        System.out.println(ans);
        int[] result = new int[2];
        for(int n: nums)
        {
            if((ans & n) == 0)result[0] ^= n;
            else result[1] ^= n;
            System.out.println(Arrays.toString(result));
        }
        return result;
    }
}