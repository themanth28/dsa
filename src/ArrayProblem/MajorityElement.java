package ArrayProblem;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();

//        int[] nums = {2,2,3,3,3,3,2};
//        System.out.println(majorityElement(nums));
//        int[] nums1 = {2,2,1,1,1,2,2};
//        System.out.println(majorityElement(nums1));
//        int[] nums2 = {3,2,3};
//        System.out.println(majorityElement(nums2));
        int[] nums3 = {8,9,8,9,8};
        System.out.println(me.majorityElement(nums3));
    }

    int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int iCount = 0;
        int f = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] == f){
                count++;
            }else{
                iCount += count;
                f = nums[i];
                count=1;
            }
            if(count>n/2 || iCount>n/2){
                return nums[i];
            }
        }


        return -1;
    }
}
