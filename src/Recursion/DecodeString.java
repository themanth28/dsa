package Recursion;

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        System.out.println(decodeString(str));
    }

//    public static String twoPointer(String s){
//        String res = "";
//        int left = 0, right = 0;
//        while (left<=right){
//            char ch = s.charAt(left);
//            if(ch == '['){
//
//            }
//            right++;
//        }
//    }

    public static String decodeString(String s) {
        return decode(s, "",0,0);
    }

    public static String decode(String s, String res, int start, int end){
        char ch = s.charAt(start);
        if(ch == '['){
            start++;
        }
        return s;
    }
}
