package StringProblem;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLettersII("cbacdcbc"));
    }

    public static String removeDuplicateLettersII(String s) {
        Map<Character, Integer> lastOccurence = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            lastOccurence.put(s.charAt(i), i);
        }

        Stack<Character> st = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            if(visited.contains(s.charAt(i))){
                continue;
            }

            while(!st.isEmpty() && s.charAt(i) < st.peek() && i < lastOccurence.getOrDefault(st.peek(), -1)){
                visited.remove(st.pop());
            }

            st.push(s.charAt(i));
            visited.add(s.charAt(i));

        }

        StringBuilder str = new StringBuilder();

        for(char ch : st){
            str.append(ch);
        }

        return str.toString();
    }
    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}