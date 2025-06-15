package BitManipulation;


//https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/?envType=problem-list-v2&envId=bit-manipulation
public class FindTheKthCharacter {
    public static void main(String[] args) {
        int k = 1;
        System.out.println(kthCharacter(k));
    }

    static char kthCharacter(int k) {

        k = k-1;
        int count = 0;
        while(k>0){
            if((k & 1) != 0){
                count++;
            }
            k >>= 1;
        }
        System.out.println(count);
        return (char) ('a' + count);


    }
}
