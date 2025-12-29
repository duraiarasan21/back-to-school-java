package org.java.programs.beginner;

import java.util.Arrays;

/* 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0,0,1]
 * Output: [1,0,0]
 *
 */

public class MoveZeroes {

    public static int[] moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0; // Pointer for the position of the next non-zero element
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // Fill the remaining positions with zeros
        for (int i = j; i < n; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    public static int[] moveZeroesOptimized(int[] nums) {
        int n = nums.length;
        int j = 0; // Pointer for the position of the next non-zero element
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    public static int[] moveZeroesSwap(int[] nums) {
        int n = nums.length;
        int j = 0; // Pointer for the position of the next non-zero element
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // Swap only if i and j are different
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0,0,1};
        int[] nums3 = {4,2,4,0,0,3,0,5,1,0};
        System.out.println(Arrays.toString(moveZeroes(nums1)));
        System.out.println(Arrays.toString(moveZeroesOptimized(nums2)));
        System.out.println(Arrays.toString(moveZeroesSwap(nums3)));
    }
}
