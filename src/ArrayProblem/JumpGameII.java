package ArrayProblem;

public class JumpGameII {
    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
         System.out.println(canJump(arr));
    }
    static int canJump(int[] nums){
        int n = nums.length-1;
        int sum = 0;
        int count = 0;
        int iCount = 0;
        int i = 0;
        while(i>=n){
            if(sum>n){
                return count;
            }
            if(nums[i]>=1){
                sum += nums[i];
                iCount++;
                count++;
                if(nums[i]==1){
                    i++;
                }
            }
            else {
                i++;
                sum += nums[i];
                count -= iCount;
            }
        }

//        for (int j : nums) {
//            if (sum >= n) {
//                return count;
//            }
//            if(j!=0){
//            sum = sum + j;
//            count++;
//            }
//        }
        return count;
    }
}
