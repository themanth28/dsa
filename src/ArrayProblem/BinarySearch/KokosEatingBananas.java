package ArrayProblem.BinarySearch;

public class KokosEatingBananas {
    public static void main(String[] args) {
        int[] piles = {2,3,5,6,7,8};
        int hr = 10;
        System.out.println(minEatingSpeed(piles,hr));
    }

    static int minEatingSpeed(int[] piles, int hr){
        int start = 1, end = Integer.MIN_VALUE, count = 0;
        for (int j : piles) {
            if (end < j) {
                end = j;
            }
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            for (int j : piles) {
                count += Math.ceil((double) j / mid);
            }
            if(count<=hr){
                end = mid-1;
            }else {
                start = mid+1;
            }
            count = 0;
        }
        return start;
    }
}
