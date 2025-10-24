package ProblemSolving.Arrays;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(words,16));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        int sum = words[0].length();
        int count = 1;
        for(int i=1 ;i<n; i++){
            sum += words[i].length();
            count += 1;
            if(sum>=maxWidth-1){
                sum -= words[i].length();
                count -=1;
                int k = count;
                int spaces = (maxWidth-1-sum) / count;
                StringBuilder str = new StringBuilder();
                for(int j=0; j<count; j++){
                    str.append(spaceGenerator(spaces)).append(words[i - k]);
                    k--;
                }
                list.add(str.toString());
                sum = 0;
                count = 0;
                i--;
            }
        }
        return list;
    }

    public static String spaceGenerator(int i){
        StringBuilder ans = new StringBuilder();
        while(i>=0){
            ans.append(" ");
            i--;
        }
        return ans.toString();
    }
}
