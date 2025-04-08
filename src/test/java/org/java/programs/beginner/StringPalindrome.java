package org.java.programs.beginner;

public class StringPalindrome {

    static void reverse(String input){
        input = input.toLowerCase();
        StringBuilder builder = new StringBuilder(input);
        builder.reverse();

        if(input.contentEquals(builder)){
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }
    }

    public static void main(String[] args) {
        reverse("Durai");
        reverse("Madam");
    }
}
