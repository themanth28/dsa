package ProblemSolving;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
        System.out.println(numRabbits(arr));
    }
    public static int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int rabbitcount=0;
        for(int i=0;i<answers.length;i++){
            int j=0;
            while((i!=answers.length-1)&&(j<answers[i])&&answers[i]==answers[i+1]){
                i++;
                j++;
            }
            rabbitcount=rabbitcount+(answers[i]+1);
        }
        return rabbitcount;
        
    }
}