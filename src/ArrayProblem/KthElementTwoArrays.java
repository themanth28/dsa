package ArrayProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class KthElementTwoArrays {

    public static void main(String[] args) {
//        int[] a = {5, 5, 8, 8, 8, 9, 11, 11, 11, 11, 11};
//        int[] b = {4, 4, 4, 4, 6, 8, 9, 9, 9, 11, 13};
        int[] a = {6, 6, 9, 10, 10, 11, 12};
        int[] b = {4, 5, 5, 6, 10, 11, 13};
//        System.out.println(kthElement(a,b,7));
        System.out.println(kElement(a,b,10));
    }

    static int kElement(int[] a, int[] b, int k){
        int n = a.length;
        int count = 0;
        int bCount = 0;
        for(int i=0; i<n; i++){
            if(a[i] >= b[bCount]){
                if(k == count){
                    return b[bCount];
                }
                count += 1;
                bCount++;
            }
            if(k == count){
                return a[i];
            }
            count += 1;
        }
        return 0;
    }




    static int kthElement(int[] a, int[] b, int k) {

        Set<Integer> comb = new HashSet<>();
        for (int j : a) {
            comb.add(j);
        }
        for (int j : b){
            comb.add(j);
        }
        int[] com = comb.stream().mapToInt(Integer::intValue).toArray();
        int n = com.length;
        for(int i=0; i<k; i++){
            int minElement = minEle(com, i, n-1);
            swap(com, minElement, i);
        }
        return com[k-1];
    }
    
    static int minEle(int[] arr, int first, int last){
        int minIndex = first;
        for(int i=first; i<last; i++){
            if(arr[minIndex] > arr[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    static void swap(int[] com, int a, int b){
        int temp = com[b];
        com[b] = com[a];
        com[a] = temp;
    }
    
}