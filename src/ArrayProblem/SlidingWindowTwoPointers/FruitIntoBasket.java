package ArrayProblem.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        int k =2;
        System.out.println(maxLength(fruits,k));
    }

    static int maxLength(int[] fruits, int k){
        int l=0, r=0, maxLen=0, n=fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<n){
            map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);
            if(map.size()>k){
                int fruit = fruits[l];
                map.put(fruit,map.get(fruit)-1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
