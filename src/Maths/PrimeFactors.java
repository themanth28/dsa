package Maths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        int n = (int) (Math.random()*1000);
        System.out.println("Input: " + n);
        List<Integer> list = new ArrayList<>();

        for(int i=2; i<Math.sqrt(n); i++){
            if(n%i == 0){
                list.add(i);
                while (n%i == 0){
                    n =n/ i;
                }
            }
        }
        if(n!=1){
            list.add(n);
        }
        System.out.println(list);
    }
}
