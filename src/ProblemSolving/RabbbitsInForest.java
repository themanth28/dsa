package ProblemSolving;

import java.util.Arrays;

public class RabbbitsInForest {
    public static void main(String[] args) {
        int[] arr = {4,4,4,4,4,5,5,6,0,0,0,0};
        System.out.println(rabbitsCount(arr));
    }

    private static int rabbitsCount(int[] answers) {
        Arrays.sort(answers);

        int count = 0;
        int sameColour = -1;
        int sameColourCount = 0;

        int n = answers.length;
//        int sameColour = answers[0];
//        int count = sameColour+1;
//        int sameColourCount = 1;

        for (int i = 0; i < n; i++) {
            if (answers[i] != sameColour || sameColourCount == answers[i] + 1) {
                count += answers[i] + 1;        // New group or overflow
                sameColour = answers[i];       // Reset to new group type
                sameColourCount = 1;           // Start new group
            } else {
                sameColourCount++;             // Continue current group
            }
        }

//        for(int i=1; i<n; i++){
//            if(answers[i] == 0 || answers[i] != sameColour){
//                sameColourCount = 1;
//                count += answers[i] +1;
//                sameColour = answers[i];
//            }else {
//                sameColourCount++;
//            }
//            if(sameColourCount > answers[i]+1){
//                sameColourCount = 1;
//                count += answers[i] +1;
//                sameColour = answers[i];
//            }
//        }
        return count;
    }
}
