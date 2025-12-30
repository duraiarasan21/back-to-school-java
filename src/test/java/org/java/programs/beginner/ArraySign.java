package org.java.programs.beginner;

/* 1822. Sign of the Product of an Array
 * Description:
 * Given an integer array nums, return the sign of the product of all the numbers in the array.
 * The sign of the product can be:
 * 1 if the product is positive.
 * -1 if the product is negative.
 * 0 if the product is zero.
 *
 * Example 1:
 * Input: nums = [-1,-2,-3,-4,3,2,1]
 * Output: 1
 * Explanation: The product of all values in the array is 144, and sign(144) = 1
 *
 * Example 2:
 * Input: nums = [1,5,0,2,-3]
 * Output: 0
 * Explanation: The product of all values in the array is 0, and sign(0) = 0
 *
 * Example 3:
 * Input: nums = [-1,1,-1,1,-1]
 * Output: -1
 * Explanation: The product of all values in the array is -1, and sign(-1) = -1
 *
 */
public class ArraySign {

    public static int arraySign(int[] nums) {
        int sign = 1; // Initialize sign as positive

        for (int num : nums) {
            if (num == 0) {
                return 0; // If any number is zero, the product is zero
            } else if (num < 0) {
                sign = -sign; // Flip the sign for each negative number
            }
        }

        return sign; // Return the final sign
    }

    public static int arraySignOptimized(int[] nums) {
        int negativeCount = 0; // Count of negative numbers

        for (int num : nums) {
            if (num == 0) {
                return 0; // If any number is zero, the product is zero
            } else if (num < 0) {
                negativeCount++; // Increment count for each negative number
            }
        }

        // If the count of negative numbers is even, the product is positive; otherwise, it's negative
        return (negativeCount % 2 == 0) ? 1 : -1;
    }

    public static int arraySignBruteForce(int[] nums) {
        long product = 1; // Use long to prevent overflow

        for (int num : nums) {
            product *= num;
            if (product == 0) {
                return 0; // If product becomes zero, return 0
            }
        }

        return (product > 0) ? 1 : -1; // Return sign based on the product
    }


    public static void main(String[] args){
        int[] numsOne = {-1,-2,-3,-4,3,2,1};
        int[] numsTwo = {1,5,0,2,-3};
        int[] numsThree = {-1,1,-1,1,-1};

        System.out.println(arraySign(numsOne)); // Output: 1
        System.out.println(arraySign(numsTwo)); // Output: 0
        System.out.println(arraySign(numsThree)); // Output: -1

        System.out.println(arraySignOptimized(numsOne)); // Output: 1
        System.out.println(arraySignOptimized(numsTwo)); // Output: 0
        System.out.println(arraySignOptimized(numsThree)); // Output: -1

        System.out.println(arraySignBruteForce(numsOne)); // Output: 1
        System.out.println(arraySignBruteForce(numsTwo)); // Output: 0
        System.out.println(arraySignBruteForce(numsThree)); // Output: -1
    }
}
