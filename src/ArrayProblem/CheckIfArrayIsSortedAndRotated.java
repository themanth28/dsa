package ArrayProblem;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4};
        System.out.println(check(arr)); // true
    }

    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (nums[i] > nums[next]) {
                count++;
            }
        }

        return count <= 1;
    }
}
