package StringProblem;

import java.util.HashMap;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    static public boolean isSubsequence(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(char c : s.toCharArray()){
            count++;
            map.put(c,count);
        }
        int check = 0;
        for(int i=0; i<t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                check++;
                if(check != map.get(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
