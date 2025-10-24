package ProblemSolving.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution(arr));
    }

    private static int solution(int[] height) {
        int n = height.length - 1;
        if(n==1){
            return Math.min(height[0], height[1]);
        }
        int l = 0;
        int r = n;
        int product = 1;
        int maxProduct = 1;

        while(l<r){
            int min = Math.min(height[l], height[r]);
            product = Math.max((min * (r-l)), product);
            if(height[l+1] > height[l]){
                l++;
            }else if(height[r-1]>height[r]){
                r--;
            }else{
                l++;
                r--;
            }
        }
        return product;
    }
}
