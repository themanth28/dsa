package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DistinctDigitArray {
    public static void main(String[] args) {
        int[] arr = {111,222,333,444};
        System.out.println(Arrays.toString(resultArray(arr)));
    }

    private static int[] resultArray(int[] arr) {
//        String str = Arrays.stream(arr)
//                .mapToObj(String::valueOf)
//                .reduce("", (s1, s2) -> s1 + s2);
        StringBuilder str = new StringBuilder();
        for (int num : arr) {
            str.append(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            int ind = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(!list.contains(ind)) {
                list.add(ind);
            }
        }
        int[] retAns = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            retAns[i] = list.get(i);
        }
        return retAns;
    }

}
