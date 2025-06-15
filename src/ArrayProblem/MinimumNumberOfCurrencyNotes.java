package ArrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfCurrencyNotes {
    public static void main(String[] args) {
        int n = 9087383;
        System.out.println(solution(n));
    }
    static Map<String,Integer> solution(int n){
        int[] arr = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(n>=arr[i]){
                addToMap(map, String.valueOf(arr[i]));
                n -= arr[i];
                if(n >= arr[i]){
                    i--;
                }
            }
        }
        return map;
    }
    public static void addToMap(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}
