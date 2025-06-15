package ArrayProblem;

public class DistributeCandies {
    public static void main(String[] args) {
        int[] arr = {5,3,2,7};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {

        int candies = arr.length;
        int min = arr[0], max = arr[0];
        int maxCount = 1, minCount = 1;

        for(int i =1; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
                minCount++;
            }
            else if(arr[i] > max){
                max = arr[i];
                candies += maxCount;
                maxCount++;
            }else if(arr[i] > min && arr[i] < max){
                candies++;
                candies++;
            }
        }
        if(minCount == candies){
            candies = 0;
            for (int i=0; i<arr.length; i++){
                candies += arr[i];
            }
        }

        return candies;
    }
}
