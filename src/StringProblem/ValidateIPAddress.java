package StringProblem;

//https://leetcode.com/problems/validate-ip-address/
public class ValidateIPAddress {
    public static void main(String[] args) {
        String str1 = "172.0.254.0";
        String str2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(str1));
    }

    public static String validIPAddress(String queryIP) {
        int n = queryIP.length();
        if(n>=7 && n<=15 && check(queryIP, "v4",n)){
            return "IPv4";
        } else if (n >= 15 && n <= 39) {

        }
        else{
            return "Neither";
        }
        return "Neither";
    }

    public static boolean check(String str, String what, int length){
        int inCount = 0;
//        int count = 0;
        int number = 0;
        if(what.equals("v4")){
            int range = 255;
            for(int i=0; i<length; i++){
                char charAt = str.charAt(i);
                if(charAt != '.'){
                    inCount += 1;
                    number = (number * 10) + Integer.parseInt(String.valueOf(charAt));
                    if(number>range){
                        return false;
                    }
                }else {
                    if(number > 0 && number%Math.pow(10,inCount-1) == number){
                        return false;
                    }
                    inCount = 0;
                    number = 0;
                }
            }
            return true;
        }
        return false;
    }
}
