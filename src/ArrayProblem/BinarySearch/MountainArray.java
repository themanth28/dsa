package ArrayProblem.BinarySearch;

public class MountainArray {

    public static void main(String[] args) {

//        int[] nums = {1,2,3,4,5,6,7,9,3,1};
        int[] nums = {0,1,2,4,2,1};
        int target = 4;
//        System.out.println(peakElementInMountainArray(nums));

        int start = 0;
        int end = nums.length - 1;

        int peak = peakElementInMountainArray(nums, start, end);

        int firstTry = binarySearch(nums, target, start, peak);
        if (nums[firstTry] == target) {
            System.out.println(firstTry);
        } else {
            int secondTry = binarySearch(nums, target, peak, end);
            if (nums[secondTry] == target) {
                System.out.println(secondTry);
            }
        }


    }

    static int peakElementInMountainArray(int[] nums, int start, int end){

        while(start < end){

            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else {
                start = mid+1;
            }

        }
        return start;
    }

    static int binarySearch(int[] nums, int target, int start, int end){

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}
