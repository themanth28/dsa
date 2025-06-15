package ArrayProblem;/* Java program to count total numbers which
have difference with sum of digits greater 
than specific value */

class Test
{
    // Utility method to get sum of digits of K
    static int sumOfDigit(int K) {
        // loop until K is not zero
        int sod = 0;
        while (K != 0) {
            sod += K % 10;
            K /= 10;
        }
        return sod;
    }

    // method returns count of numbers smaller than N,
    // satisfying difference condition
    static int totalNumbersWithSpecificDifference(int N, int diff) {
        int low = 1, high = N;

        // binary search while loop
        while (low <= high) {
            int mid = (low + high) / 2;

            /* if difference between number and its sum
            of digit is smaller than given difference
            then smallest number will be on left side */
            if (mid - sumOfDigit(mid) < diff)
                low = mid + 1;

            /* if difference between number and its sum
            of digit is greater than or equal to given
            difference then smallest number will be on
            right side */
            else
                high = mid - 1;

            System.out.println("start: " + low + " end: " + high + " mid " + mid);
        }

        // return the difference between 'smallest number
        // found' and 'N' as result
        return (N - high);
    }

    // Driver method
    public static void main(String[] args) {
        int N = 130;
        int diff = 20;

        System.out.println(totalNumbersWithSpecificDifference(N, diff));
    }
}
