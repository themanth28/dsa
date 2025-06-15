package StringProblem;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args) {
        String str = "25525511135";
        System.out.println(restoreIpAddresses(str));
    }

    static public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        int size = s.length()+3;
        int number = 0;
        List<String> stringList = new ArrayList<>();
        int count = 0;
        String str = "";
        
        System.out.println(str);
        return stringList;
    }
}
