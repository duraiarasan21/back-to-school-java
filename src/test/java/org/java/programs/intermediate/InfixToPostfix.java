package org.java.programs.intermediate;

import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and output from the stack until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '(' from stack
                }
            }
            // If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (stack.peek() == '(') {
                        break;
                    }
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Unmatched parentheses
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Function to return precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        String expression = "a+b-c";
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + infixToPostfix(expression));
    }
}