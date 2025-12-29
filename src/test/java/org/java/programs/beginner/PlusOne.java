package org.java.programs.beginner;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static int[] plusOneOptimized(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static int[] plusOneModulus(int[] digits) {

        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digitsOne = {1, 2, 3};
        int[] digitsTwo = {4, 3, 2, 1};
        int[] digitsThree = {9, 9, 9};

        System.out.println(Arrays.toString(plusOne(digitsOne)));
        System.out.println(Arrays.toString(plusOneOptimized(digitsTwo)));
        System.out.println(Arrays.toString(plusOneModulus(digitsThree)));
    }
}
