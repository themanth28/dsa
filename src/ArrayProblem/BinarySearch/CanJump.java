package ArrayProblem.BinarySearch;

class CanJump {

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
    static boolean canJump(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            int max = nums[i];
            int sum = 0;
            for(int j = max; j > 0; j--){
                sum = sum + j;
                while(j < n){
                    System.out.println(nums[j]);
                    if(nums[j] != 0){
                        sum = sum + nums[j];
                        System.out.println("sum " + sum +" "+ nums[j]);
                        if (sum > n-1) {
                            return true;
                        }
                        j++;
                        System.out.println("sum " + sum);
                    }else {
                        break;
                    }
                }
                sum = 0;
            }
            i++;
        }
        return false;
    }
}