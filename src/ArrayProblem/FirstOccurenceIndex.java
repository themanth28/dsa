package ArrayProblem;

public class FirstOccurenceIndex {

    public static void main(String[] args) {
        String a = "hello";
        String b = "ll";
        System.out.println(strStr(a,b));

    }

    static int strStr(String haystack, String needle) {
        int n = haystack.length() - 1;
        int m = needle.length();
        System.out.println(m);
        int a = 0;
        int count = 1;
        for(int i = 0; i < n ; i++){
            if(needle.charAt(a) == haystack.charAt(i)){
                for(int j = 0; j < m; j++){
                    System.out.println("a " + ++a);
                    if(needle.charAt(a++) == haystack.charAt(i++)){
                        System.out.println(a);
                        System.out.println("j if");
                        count++;
                    }
                    if(count == m){
                        System.out.println("i "+i);
                        return i-m+1;
                    }
                }
                a = 0;
            }
        }
        return a-1;
    }
}
