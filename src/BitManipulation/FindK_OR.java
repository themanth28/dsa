package BitManipulation;

public class FindK_OR {
    public static void main(String[] args) {
        int[] arr = {14,7,12,9,8,9,1,15};
        int k = 4;
        System.out.println(findKOr(arr,k));

    }
    public static int findKOr(int[] nums, int k) {
        int ans = 0;

        int n = nums.length;
        int i = 0;
        int sum = 0;
        int one = 0;
        boolean okay = false;
        while (!okay){
            sum += nums[i];
            one += nums[i] & 1;
            nums[i] >>= 1;
            if(sum == 0 && i == n-1){
                okay = true;
            }
            if(i == n-1 && sum > 0){
                if(one >= k){
                    ans += 1;
                    ans <<= 1;
                }else {
                      ans += 0;
                    ans <<= 1;
                }
                one = 0;
                i=0;
                sum=0;
            }
            i++;
        }

        return ans;
    }
}
