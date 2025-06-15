package ArrayProblem.BinarySearch;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example list
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));

        // Sorting the list using List.sort() with a lambda expression
        list.sort((a, b) -> a - b);

        // Printing the sorted list
        System.out.println("Sorted list: " + list);
    }
}
