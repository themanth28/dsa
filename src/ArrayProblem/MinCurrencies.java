package ArrayProblem;

public class MinCurrencies {
    public static void main(String[] args) {
        currencies(30);
    }

    static void currencies(int k){
        int[] arr = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        int i=0;
        while (k>0){
            if(k/arr[i]>0){
                System.out.println(arr[i] + " " + (k/arr[i]));
                k = k % arr[i];
            }
            i++;
        }
    }
}
