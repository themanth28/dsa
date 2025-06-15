package ProblemSolving;

public class MaximumConsecutiveSubArrays {
    public static void main(String[] args) {
        int[] a = {1, 1, 0,0,0,0,0,0,0,0,0, 0, 1, 0, 1, 0, 1, 1, 1, 1,1,1,1};
        max(a);
    }

    static void max(int[] arr){
        int right = 1;
        int ans = 1;
        int inc = 1;
        while (right< arr.length){
            if(arr[right-1] != arr[right]){
                ans = Math.max(ans,inc);
                inc = 1;
            }else {
                inc++;
            }
            right++;
        }
        System.out.println(ans);
    }
}
