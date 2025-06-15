package ProblemSolving.BinarySearch;

class Solution {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
    static boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int start = 2;
        int end = num/2;
        while(start <= end){
            int mid = start + (end-start)/2;
            long perfectSquare = (long) mid *mid;
            System.out.println("s " + start + " e " + end + " m " + mid);
            if(perfectSquare == num){
                return true;
            }
            if(perfectSquare > num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            System.out.println("s " + start + " e " + end + " m " + mid);
        }
        return false;
    }
}