package ArrayProblem;

class CanJump {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }
    static boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
            System.out.println(goal + " " + i + " ");
        }
        return goal == 0;
    }

//    static int canJump(int[] nums) {
//        int goal = nums.length - 1;
//        int sum = 0;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i + nums[i] >= goal) {
////                System.out.println(i + nums[i]);
//                sum = goal - i ;
//                goal = i;
//            }
////            System.out.println(goal + " " + i + " "+ sum);
//        }
//        return 0;
//    }
}