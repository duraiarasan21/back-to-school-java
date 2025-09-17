package org.java.programs.beginner;

public class MaximumTripletProduct {

    public static int maxProductNaiveApproach(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            throw new IllegalArgumentException("Array must contain at least three elements.");
        }

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int product = arr[i] * arr[j] * arr[k];
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
        }

        return maxProduct;
    }

    public static int maxProductGreedyApproach(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            throw new IllegalArgumentException("Array must contain at least three elements.");
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }


    public static void main(String[] args) {
        int[] arr = { 10, 3, 5, 6, 20, 8 };
        System.out.println("Maximum Triplet Product: " + maxProductNaiveApproach(arr));
        System.out.println("Maximum Triplet Product: " + maxProductGreedyApproach(arr));
    }
}
