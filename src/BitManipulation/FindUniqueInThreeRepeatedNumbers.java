package BitManipulation;

public class FindUniqueInThreeRepeatedNumbers {

    public static int unique3(int[] nums) {
        int result = 0;

        // Iterate over all 32 bits
        for (int i = 0; i < 8; i++) {
            int bitSum = 0;

            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    System.out.println("i " + i + " num: " + num+ " & (1 << i)): " + (num & (1 << i)));
                    bitSum++;
                }
            }
            System.out.println("bitsum: " + bitSum);

            if (bitSum % 3 != 0) {
                result |= (1 << i);
            }
            System.out.println("result: " + result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 7, 7, 8, 7, 8, 8, 2};
        System.out.println("Unique number: " + unique3(nums)); // Output: 3
    }
}
