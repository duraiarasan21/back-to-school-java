package org.java.programs.beginner;

public class StringPalindrome {

    public void reverse(String input){
        StringBuilder builder = new StringBuilder(input);
        builder.reverse();

        if(input.contentEquals(builder)){
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }
    }
}
