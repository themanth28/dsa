package Recursion;

public class Palindrome {
    public static void main(String[] args) {
        String str = "ABCDCBA";
        System.out.println(palindrome(str,0,str.length()-1));
    }
    static boolean palindrome(String str, int start, int end){
        if(start>end){
            return true;
        }
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }
        return palindrome(str,start+1,end-1);
    }
}