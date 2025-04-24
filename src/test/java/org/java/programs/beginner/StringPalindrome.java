package org.java.programs.beginner;

public class StringPalindrome {

    static void reverseInbuildFunction(String input){
        input = input.toLowerCase();
        StringBuilder builder = new StringBuilder(input);
        builder.reverse();

        if(input.contentEquals(builder)){
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }
    }

    static void isPalindromeTwoPointer(String input){
        input = input.toLowerCase();
        int i = 0;
        int j = input.length() - 1;
        boolean result = true;

        while(i < j){
            if (input.charAt(i) != input.charAt(j)) {
                result = false;
                break;
            }
            i++;
            j--;
        }

        if(result){
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }


    }

    public static void main(String[] args) {
        reverseInbuildFunction("Durai");
        isPalindromeTwoPointer("Madam");
    }
}
