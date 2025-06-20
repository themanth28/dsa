package ArrayProblem;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sol = new StringBuilder();
        int len = 0;
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                len++;
            }else {
                String newStr = s.substring(i-len,i);
                len = 0;
                sol.append(newStr).append(" ");
            }
        }
        return len > 0? sol.append(s, s.length()-1-len, s.length()).toString() : sol.toString();
    }
}
