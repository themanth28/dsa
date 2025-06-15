package StringProblem;

public class CheckForSubsequence {
    public static void main(String[] args) {
        String s = "gksrek";
        String t = "geeksforgeeks";

        System.out.println(isSubSequence(s,t));
    }
    private static boolean isSubSequence(String s, String t) {
        int count = 0;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(count) == t.charAt(i)){
                count++;
            }
            if(count == s.length()){
                return true;
            }
        }
        return false;
    }
}
