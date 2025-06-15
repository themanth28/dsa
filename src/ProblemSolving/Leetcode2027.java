package ProblemSolving;

public class Leetcode2027 {
    public static void main(String[] args) {
        String str = "OXOOX";
        System.out.println(minimumMoves(str));

    }

    public static int minimumMoves(String s) {
        int ans = 0, left = 0;
        int right = 0, XCount = 0, OCount = 0;
        while (right<s.length()){
            char ch = s.charAt(right);
            if(ch == 'X'){
                XCount++;
                OCount = 0;
            }else {
                OCount++;
            }
            if(XCount == 1 && OCount == 0){
                left = right;
            }
            if((right-left+1) % 3 == 0 && XCount>0){
                ans++;
                XCount = 0;
            }
            right++;
        }
        return XCount>0? ans+1 : ans;
    }

}
