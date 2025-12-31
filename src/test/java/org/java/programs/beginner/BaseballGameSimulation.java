package org.java.programs.beginner;

import java.util.Stack;

/*
 * 682. Baseball Game Simulation
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores. At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 * An integer x - Record a new score of x.
 * "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record after applying all the operations.
 *
 * Example 1:
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add double the previous score (5 * 2 = 10), record is now [5, 10].
 * "+" - Add the sum of the previous two scores (5 + 10 = 15), record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 *
 * Example 2:
 * Input: ops = ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "-2" - Add -2 to the record, record is now [5, -2].
 * "4" - Add 4 to the record, record is now [5, -2, 4].
 * "C" - Invalidate and remove the previous score, record is now [5, -2].
 * "D" - Add double the previous score (-2 * 2 = -4), record is now [5, -2, -4].
 * "9" - Add 9 to the record, record is now [5, -2, -4, 9].
 * "+" - Add the sum of the previous two scores (-4 + 9 = 5), record is now [5, -2, -4, 9, 5].
 * "+" - Add the sum of the previous two scores (9 + 5 = 14), record is now [5, -2, -4, 9, 5, 14].
 * The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
 *
 */

public class BaseballGameSimulation {

    public static int calPoints(String[] ops) {
        int totalScore = 0;
        Stack<Integer> scoreStack = new Stack<>();

        for (String op : ops) {
            switch (op) {
                case "+":
                    int last = scoreStack.pop();
                    int newScore = last + scoreStack.peek();
                    scoreStack.push(last);
                    scoreStack.push(newScore);
                    break;
                case "D":
                    scoreStack.push(2 * scoreStack.peek());
                    break;
                case "C":
                    scoreStack.pop();
                    break;
                default:
                    scoreStack.push(Integer.parseInt(op));
                    break;
            }
        }

        for (int score : scoreStack) {
            totalScore += score;
        }

        return totalScore;
    }

    public static int calPointsOptimized(String[] ops) {
        int totalScore = 0;
        int[] scores = new int[ops.length];
        int index = 0;

        for (String op : ops) {
            switch (op) {
                case "+":
                    scores[index] = scores[index - 1] + scores[index - 2];
                    index++;
                    break;
                case "D":
                    scores[index] = 2 * scores[index - 1];
                    index++;
                    break;
                case "C":
                    index--;
                    break;
                default:
                    scores[index] = Integer.parseInt(op);
                    index++;
                    break;
            }
        }

        for (int i = 0; i < index; i++) {
            totalScore += scores[i];
        }

        return totalScore;
    }

    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops1)); // Output: 30
        System.out.println(calPointsOptimized(ops1)); // Output: 30

        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops2)); // Output: 27
        System.out.println(calPointsOptimized(ops2)); // Output: 27

    }
}
