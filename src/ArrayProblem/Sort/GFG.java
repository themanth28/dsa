package ArrayProblem.Sort;
import java.util.*;

class GFG {
    
    // Return the sum of distance of one axis.
    static int distancesum(int arr[], int n)
    {
        
        // sorting the array.
        Arrays.sort(arr);

        // for each point, finding the distance.
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            res += (arr[i] * i - sum);
            sum += arr[i];
        }
        System.out.println(res);

        return res;
    }

    static int totaldistancesum(int x[], int y[], int n)
    {
        // Adding the distances along x and y axis. 
        return distancesum(x, n) + distancesum(y, n);
    }

    // Driven Program
    public static void main(String[] args)
    {

        int[] x = { -1, 1, 3, 2 };
        int[] y = { 5, 6, 5, 3 };
        int n = x.length;
        System.out.println(totaldistancesum(x,y, n));
    }
}