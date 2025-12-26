package org.java.programs.beginner;

import java.util.Arrays;

/* 1502. Can Make Arithmetic Progression From Sequence
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * Given an array of numbers arr, return true if the numbers can be rearranged to form an arithmetic progression. Otherwise, return false.
 * Example 1:
 * Input: arr = [3,5,1]
 * Output: true
 * Explanation: We can rearrange the elements as [1,3,5] or [5,3,1] with a common difference of 2.
 *
 * Example 2:
 * Input: arr = [1,2,4]
 * Output: false
 * Explanation: There is no way to rearrange the elements to obtain an arithmetic progression.
 */
public class ArithmeticProgressionFromSequence {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length <= 1){
            return true;
        }
        Arrays.sort(arr);

        int commonDifference = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != commonDifference) {
                return false;
            }
        }
        return true;
    }

    public static boolean canMakeArithmeticProgressionUsingSet(int[] arr) {
        if(arr.length <= 1){
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        int n = arr.length;
        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int commonDifference = (max - min) / (n - 1);

        for (int i = 0; i < n; i++) {
            int expectedValue = min + i * commonDifference;
            if (!set.contains(expectedValue)) {
                return false;
            }
        }

        return true;
    }

    public static boolean canMakeArithmeticProgressionOptimized(int[] arr) {
        if(arr.length <= 1){
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int n = arr.length;
        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int commonDifference = (max - min) / (n - 1);
        boolean[] seen = new boolean[n];

        for (int num : arr) {
            if ((num - min) % commonDifference != 0) {
                return false;
            }
            int index = (num - min) / commonDifference;
            if (index < 0 || index >= n || seen[index]) {
                return false;
            }
            seen[index] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 1};
        int[] arr2 = {1, 2, 4};
        System.out.println(canMakeArithmeticProgression(arr1)); // true
        System.out.println(canMakeArithmeticProgression(arr2)); // false
        System.out.println(canMakeArithmeticProgressionUsingSet(arr1)); // true
        System.out.println(canMakeArithmeticProgressionUsingSet(arr2)); // false
        System.out.println(canMakeArithmeticProgressionOptimized(arr1)); // true
        System.out.println(canMakeArithmeticProgressionOptimized(arr2)); // false
    }
}
