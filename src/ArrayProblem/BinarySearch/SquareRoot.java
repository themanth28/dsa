package ArrayProblem.BinarySearch;

public class SquareRoot {
    public static void main(String[] args) {

        int inp = 81;
        System.out.println(answer(inp));
    }
    static int answer(int inp){
        int start = 1;
        int end = inp/2 +1;

        while (start<=end){

            int mid = start + (end - start)/2;
            long mids = (long) mid *mid;
            if(mids<=inp){
                start = mid+1;
            }else {
                end = mid - 1;
            }

        }
        return end;
    }
}
