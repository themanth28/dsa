package StringProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FirstUniqChar {
    public static void main(String[] args) {
        String str = "kalaimani";
        System.out.println(stUniqChar(str));
    }
    static int stUniqChar(String s) {
        int[] alphabet = new int[26];
        for(char c : s.toCharArray()){
            alphabet[c - 'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(alphabet[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}