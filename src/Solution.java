import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(arr));
    }
    static ArrayList<Integer> findTwoElement(int[] arr) {
        // code here
        int tot = (arr.length / 2) * (arr.length+1);

        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if(sum > tot){
            ans.add(arr.length);
            ans.add(arr.length-1);
        }else{
            ans.add(sum - (tot-arr.length)-1);
            ans.add(tot-sum+1);
        }

        return ans;

    }
}
