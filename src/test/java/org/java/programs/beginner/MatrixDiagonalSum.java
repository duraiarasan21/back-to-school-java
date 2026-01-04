package org.java.programs.beginner;

/*
 * Problem Description: 1572. Matrix Diagonal Sum
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 *
 * Example 1:
 * Input: mat = [[1,2,3],
 *               [4,5,6],
 *               [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 *
 * Example 2:
 * Input: mat = [[1,2,3,4],
 *               [5,6,7,8],
 *               [9,10,11,12],
 *               [13,14,15,16]]
 * Output: 68
 * Explanation: Diagonals sum: 1 + 6 + 11 + 16 + 4 + 7 + 10 + 13 = 68
 *
 * Example 3:
 * Input: mat = [[5]]
 * Output: 5
 * Explanation: Diagonals sum: 5
 *
 */

public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] matrix) {
        int row = matrix.length;
        int sum = 0;

        if(row == 1){
            return matrix[0][0];
        } else {
            for(int i = 0; i < row; i++){
                sum+= matrix[i][i];
                if((row - 1 - i) != i){
                    sum+= matrix[i][row - 1 - i];
                }
            }
        }
        return sum;
    }

    public static int diagonalSumOptimized(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i]; // Primary diagonal
            sum += matrix[i][n - 1 - i]; // Secondary diagonal
        }

        // If n is odd, subtract the middle element once as it has been added twice
        if (n % 2 == 1) {
            sum -= matrix[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrixOne = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matrixTwo = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Diagonal Sum of matrixOne: " + diagonalSum(matrixOne)); // Output: 25
        System.out.println("Diagonal Sum of matrixTwo: " + diagonalSum(matrixTwo)); // Output: 68

        System.out.println("Optimized Diagonal Sum of matrixOne: " + diagonalSumOptimized(matrixOne)); // Output: 25
        System.out.println("Optimized Diagonal Sum of matrixTwo: " + diagonalSumOptimized(matrixTwo)); // Output: 68
    }
}
