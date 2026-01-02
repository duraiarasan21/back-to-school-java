package org.java.programs.beginner;

/*
 * Problem Statement: 1672. Richest Customer Wealth
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank. Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
 *
 * Example 1:
 * Input: accounts = [[1,2,3],[3,2,1]]
 * Output: 6
 * Explanation: 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6
 *
 * Example 2:
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation: 1st customer has wealth = 6
 * 2nd customer has wealth = 10
 * 3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 *
 */

public class RichestCustomerWealth2DArray {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bankAccount : customer) {
                currentWealth += bankAccount;
            }
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }

    public static int maximumWealthOptimized(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bankAccount : customer) {
                currentWealth += bankAccount;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }

    public static int maximumWealthAlternative(int[][] accounts) {
        int[] totalWealth = new int[accounts.length];
        int maxWealth = 0;

        for(int i = 0; i < accounts.length; i++){
            for(int j = 0; j < accounts[i].length; j++){
                totalWealth[i] += accounts[i][j];
            }
        }

        for(int max : totalWealth){
            if(max >= maxWealth){
                maxWealth = max;
            }
        }
        return maxWealth;
    }

    public static void main (String[] args) {
        int[][] accountsOne = {{1, 2, 3}, {3, 2, 1}};
        int[][] accountsTwo = {{1, 5}, {7, 3}, {3, 5}};
        int[][] accountsThree = {{2, 8, 7}, {3, 6, 7}};

        System.out.println("Richest Customer Wealth: " + maximumWealth(accountsOne)); // Output: 6
        System.out.println("Richest Customer Wealth: " + maximumWealth(accountsTwo)); // Output: 10
        System.out.println("Richest Customer Wealth: " + maximumWealth(accountsThree)); // Output: 17

        System.out.println("Richest Customer Wealth (Optimized): " + maximumWealthOptimized(accountsOne)); // Output: 6
        System.out.println("Richest Customer Wealth (Optimized): " + maximumWealthOptimized(accountsTwo)); // Output: 10
        System.out.println("Richest Customer Wealth (Optimized): " + maximumWealthOptimized(accountsThree)); // Output: 17

        System.out.println("Richest Customer Wealth (Alternative): " + maximumWealthAlternative(accountsOne)); // Output: 6
        System.out.println("Richest Customer Wealth (Alternative): " + maximumWealthAlternative(accountsTwo)); // Output: 10
        System.out.println("Richest Customer Wealth (Alternative): " + maximumWealthAlternative(accountsThree)); // Output: 17
    }
}
