package org.java.programs.beginner;

public class Factorial {

    public static int factorialIterative(int number){
        int result = 1;
        for(int i = 2; i <= number; i++){
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive(int number){
        if(number == 0)
            return 1;

        return number * factorialRecursive(number - 1);
    }


    public static void main(String[] args) {
        int number = 6;
        System.out.println("Factorial of " + number + " is " + factorialIterative(number));
        number = 9;
        System.out.println("Factorial of " + number + " is " + factorialRecursive(number));
    }
}
