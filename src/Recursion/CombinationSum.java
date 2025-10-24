package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        recurse(res,comb,0,candidates,target);
        System.out.println(res);
    }

    public static void recurse(List<List<Integer>> res, List<Integer> comb, int i, int[] com, int target){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int j=i; j<com.length; j++){
            if(com[j] > target){
                continue;
            }
            comb.add(com[j]);
            recurse(res,comb,j,com,target-com[j]);
            comb.remove(comb.size()-1);
        }
    }
}
