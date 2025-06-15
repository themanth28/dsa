package StringProblem;

import static StringProblem.NextGreaterNumber.reverse;

public class NextLargestNumber {
    public static void main(String[] args) {
        String str = "172";
        System.out.println(nextBiggestNumber(str));
    }

    static String nextBiggestNumber(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = n-2;
        while (i>=0 && chars[i] >= chars[i+1]){
            i--;
        }
        if (i < 0){
            return s;
        }
        int j = n-1;
        while (chars[j] <= chars[i]){
            j--;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        reverse(chars,i+1,n-1);

        return new String(chars);
    }


}
