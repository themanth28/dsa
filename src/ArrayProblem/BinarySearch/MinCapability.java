package ArrayProblem.BinarySearch;

public class MinCapability {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        int k = 2;
        System.out.println(minCapability(arr,k));
    }

    static int minCapability(int[] nums, int k){
        int min = 0;
        int n = nums.length;
        int i = 0;
        int maxHouses = n - k;
        int[] max = new int[n*k];
        int c = 0;
        while(i<n){
            for(int j=0; j<maxHouses; j++){
//                if()
            }
        }

        return min;
    }
}
