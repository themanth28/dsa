package ArrayProblem;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
    // DO NOT MODIFY BOTH THE LISTS

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(-50, -41, -40, -19, 5, 21, 28);
        List<Integer> b = Arrays.asList(-50, -21, -10 );
        System.out.println(findMedianSortedArrays(a,b));
    }
    static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        System.out.println(a.size());
        System.out.println(b.size());
        for(int i=0; i<b.size();i++){
            a.add(b.get(i));
        }

        if(a.size() == 1){
            return a.get(0);
        }
        
        a.sort((c, d) -> c - d);
        // int size = 
        System.out.println(a);
        if(a.size()%2!=0){
            return a.get(a.size()/2);
        }else{
            return (double) (a.get(a.size() / 2) + a.get((a.size() / 2)) - 1) /2;
        }

    }
}
