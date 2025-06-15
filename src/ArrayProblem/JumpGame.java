package ArrayProblem;

public class JumpGame {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        
        if (n <= 1) {
            return 0;
        }
        
        if (arr[0] == 0) {
            return -1;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum jumps required: " + minJumps(arr));
    }
}
