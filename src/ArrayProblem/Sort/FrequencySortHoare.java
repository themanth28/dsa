package ArrayProblem.Sort;

import java.util.*;

public class FrequencySortHoare {
    public static void main(String[] args) {
        int[] arr = {5, 5, 4, 6, 4, 6, 6, 7, 7};
        sortByFrequency(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortByFrequency(int[] arr) {
        // Step 1: Build frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort using Hoare Quick Sort
        quickSort(arr, 0, arr.length - 1, freq);
    }

    private static void quickSort(int[] arr, int low, int high, Map<Integer, Integer> freq) {
        if (low < high) {
            int p = partition(arr, low, high, freq);
            quickSort(arr, low, p, freq);
            quickSort(arr, p + 1, high, freq);
        }
    }

    private static int partition(int[] arr, int low, int high, Map<Integer, Integer> freq) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Move i forward until we find element that should be on the right side
            do {
                i++;
            } while (
                (freq.get(arr[i]) > freq.get(pivot)) || 
                (freq.get(arr[i]).equals(freq.get(pivot)) && arr[i] < pivot)
            );

            // Move j backward until we find element that should be on the left side
            do {
                j--;
            } while (
                (freq.get(arr[j]) < freq.get(pivot)) || 
                (freq.get(arr[j]).equals(freq.get(pivot)) && arr[j] > pivot)
            );

            if (i >= j) return j;

            // Swap elements
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
