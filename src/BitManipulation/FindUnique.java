package BitManipulation;

public class FindUnique {
    public static void main(String[] args) {
//        int[] arr = {2,3,4,3,2,6,4,1,7,8,7,1,8};
//        int[] arr = {0,1,0,99,1,0,1,3,2,4,3,4,2,9,2,8,5,8,7,7,8,2,9,5,8};
        int[] arr = {1,2,1,3,2,5};
        System.out.println(unique(arr));

    }

    private static int unique(int[] arr) {
        int uni = 0;
        for(int n : arr){
            System.out.print(uni + " ^ " + n + ": ");
            uni = uni ^ n;
            System.out.println(uni);
        }
        return uni;

    }
}
