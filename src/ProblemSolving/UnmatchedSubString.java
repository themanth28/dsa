package ProblemSolving;

public class UnmatchedSubString {
    public static void main(String[] args) {
        String a = "schoollifeisusefull";
        String b = "schoollongofuselike";
        printSubString(a,b);
    }

    static void printSubString(String a, String b){
        StringBuilder stringBuildera = new StringBuilder();
        StringBuilder stringBuilderb = new StringBuilder();
        for(int i=0; i<a.length(); i++){
            char aC = a.charAt(i);
            char bC = b.charAt(i);
            if(aC != bC){
                stringBuildera.append(aC);
                stringBuilderb.append(bC);
            } else if (stringBuildera.length() > 0) {
                System.out.println(stringBuildera);
                System.out.println(stringBuilderb);
                stringBuildera = new StringBuilder();
                stringBuilderb = new StringBuilder();
            }
        }
        if (stringBuildera.length()>0) {
            System.out.println(stringBuildera);
            System.out.println(stringBuilderb);
        }
    }
}
