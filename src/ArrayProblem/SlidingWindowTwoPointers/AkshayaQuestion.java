package ArrayProblem.SlidingWindowTwoPointers;

public class AkshayaQuestion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,2,3,4,1};
        System.out.println(subarrayCount(arr,4));
    }

    public static int subarrayCount(int[] arr,int thr){
        int count = 0;
        int left = 0, right = 0;
        int n = arr.length;
        while (left<n){
            if(arr[left] >= thr){
                count++;
                right = left;
            }
            left++;
        }
        return right != n-1 ? count+1 : count;
    }
}
