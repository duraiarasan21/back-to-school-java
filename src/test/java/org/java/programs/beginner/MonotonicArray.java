package org.java.programs.beginner;

/* 896. Monotonic Array
 * Description:
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
 * An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 *
 * Example 1:
 * Input: nums = [1,2,2,3]
 * Output: true
 *
 * Example 2:
 * Input: nums = [6,5,4,4]
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,3,2]
 * Output: false
 *
 */

public class MonotonicArray {

    public static boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        boolean asc = true;
        boolean dec = true;

        for(int i = 0; i < n - 1; i++){

            if (!asc && !dec) {
                return false;
            }

            if(nums[i] > nums[i + 1]){
                asc = false;
            }

            if(nums[i] < nums[i + 1]){
                dec = false;
            }

        }
        return asc || dec;
    }

    public static boolean isMonotonicOptimized(int[] nums) {
        int direction = 0; // 0: unknown, 1: increasing, -1: decreasing

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                int currentDirection = Integer.compare(nums[i], nums[i - 1]);
                if (direction == 0) {
                    direction = currentDirection;
                } else if (direction != currentDirection) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isMonotonicBruteForce(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDecreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {6, 5, 4, 4};
        int[] nums3 = {1, 3, 2};

        System.out.println(isMonotonic(nums1)); // true
        System.out.println(isMonotonic(nums2)); // true
        System.out.println(isMonotonic(nums3)); // false

        System.out.println(isMonotonicOptimized(nums1)); // true
        System.out.println(isMonotonicOptimized(nums2)); // true
        System.out.println(isMonotonicOptimized(nums3)); // false

        System.out.println(isMonotonicBruteForce(nums1)); // true
        System.out.println(isMonotonicBruteForce(nums2)); // true
        System.out.println(isMonotonicBruteForce(nums3)); // false
    }
}
