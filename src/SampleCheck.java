import java.util.Arrays;

public class SampleCheck {
    public static void main(String[] args) {
        int ch = '.';
//        System.out.println(Math.ceil(1.000000001));
//        System.out.println(Math.ceil((double) 6 / 5));

//        int a = (int) (Math.ceil((double) 6 / 5) * 5);
//        System.out.println(a);
//        System.out.println(123>>1);
//
//        int[] nums = {5,7,98,32,8,0,2,43,89,0,11,7,3,93,100};
//        int max = Integer.MIN_VALUE;
//        int sub = Integer.MAX_VALUE;
//        int ans = -1;
//        for (int num : nums) {
//            if (num > max) {
//                ans = max;
//                max = num;
//            }
////            if (max != num && max - num < sub) {
////                sub = max - num;
////                ans = num;
////            }
//        }
//        System.out.println(max);
//        System.out.println(ans);



//        for(int i=0; i<10; i++){
//            System.out.println(i);
//            if(i == 5){
//                break;
//            }
//        }


//        int a = 'A';
//        int c = 'C';
//        int g = 'G';
//        int t = 'T';
//        System.out.println(a);
//        System.out.println(c);
//        System.out.println(g);
//        System.out.println(t);
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(c));
//        System.out.println(Integer.toBinaryString(g));
//        System.out.println(Integer.toBinaryString(t));
//        System.out.println(a ^ c);
//        System.out.println(a^a^c);
//        System.out.println(0^a);

//        int a = 3;
//        int c = 3;
//        int b = (a & (a-1));
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(b);
//        System.out.println(Integer.toBinaryString(b));
//        Long ab = (long) Math.pow(9,9);
//        System.out.println(ab);
//        System.out.println(3%3);

        int[] arr = {-8,-66,-60};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int a = arr.length;
        System.out.println(Math.max(arr[a-1] + arr[0], arr[a-2] + arr[a-1]));
    }
}

