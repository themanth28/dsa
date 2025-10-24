package ArrayProblem.BinarySearch;

class Solution {
    public static void main(String[] args) {
        System.out.println(findKthNumber(3,4,7));
    }
    public static int findKthNumber(int m, int n, int k) {
        // Binary search on the answer (the value of the number)
        int low = 1;
        int high = m * n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(m, n, mid);
            
            if (count >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

    // Helper method to count numbers <= val in the multiplication table
    private static int countLessOrEqual(int m, int n, int val) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // For each row 'i', the number of elements <= val is the smaller of 'n' or 'val / i'.
            count += Math.min(n, val / i);
        }
        return count;
    }
}