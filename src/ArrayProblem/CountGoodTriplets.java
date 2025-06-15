package ArrayProblem;

//https://leetcode.com/problems/count-good-triplets/description/?envType=daily-question&envId=2025-04-14

public class CountGoodTriplets {
    public static void main(String[] args) {
        int[] arr = {3,0,1,1,9,7};
        int a = 7;
        int b = 2;
        int c = 3;
        System.out.println(triplets(arr,a,b,c));
    }

    static int triplets(int[] arr, int a, int b, int c){
        int count = 0;
        for(int i=0; i<arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
