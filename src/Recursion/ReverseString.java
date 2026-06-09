package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(recursive("Hemanth"));
//        System.out.println("Hemanth".substring(0,6));
    }

    public static String recursive(String string){
        System.out.println(string);
        if(string == null || string.length() <= 1){
            return string;
        }
//        System.out.println(string);
        return string.charAt(string.length()-1) + recursive(string.substring(0,string.length()-1));

    }
}
