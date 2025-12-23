package org.java.programs.beginner;

public class ReverseString {

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverseStringInbuilt(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseStringRecursive(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return reverseStringRecursive(input.substring(1)) + input.charAt(0);
    }

    public static String reverseStringUsingStack(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println("Reversed String: " + reverseString("Reversed String"));
        System.out.println("Reversed String (Inbuilt): " + reverseStringInbuilt("Inbuilt Reverse"));
        System.out.println("Reversed String (Recursive): " + reverseStringRecursive("Recursive Reverse"));
        System.out.println("Reversed String (Using Stack): " + reverseStringUsingStack("Stack Reverse"));
    }
}
