package ProblemSolving.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
    public static String convert(String s, int numRows) {
        StringBuilder str = new StringBuilder();

        int n = s.length();
        int k = 0;
        str.append(s.charAt(k));
        int i = (numRows * 2) - 2;
        int j = 0;
        while (str.length() != s.length()) {
            if (j + i > n - 1) {
                i-=2;
                k++;
                j = k;
                str.append(s.charAt(k));
            }
            str.append(s.charAt(i + j));
            j = i + j;

        }
        return str.toString();
    }
}