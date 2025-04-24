package org.java.programs.beginner;

public class SwapTwoNumber {

    public static void swapWithThirdVariable(int varOne, int varTwo){
        System.out.println("Before Swap - \nVar One : " + varOne + "\nVar Two : " + varTwo);
        int varThird = varOne;
        varOne = varTwo;
        varTwo = varThird;
        System.out.println("After Swap - \nVar One : " + varOne + "\nVar Two : " + varTwo);
    }

    public static void swapWithoutThirdVariable(int varOne, int varTwo){
        System.out.println("Before Swap - \nVar One : " + varOne + "\nVar Two : " + varTwo);
        varOne = varOne + varTwo;
        varTwo = varOne - varTwo;
        varOne = varOne - varTwo;
        System.out.println("After Swap - \nVar One : " + varOne + "\nVar Two : " + varTwo);
    }

    public static void swapUsingXor(int varOne, int varTwo){
        System.out.println("Before Swap - \nVar One : " + varOne + "\nVar Two : " + varTwo);
        varOne = varOne ^ varTwo;
        varTwo = varOne ^ varTwo;
        varOne = varOne ^ varTwo;
        System.out.println("After Swap - \nVar One : " + varOne + "\nVar Two : " + varTwo);
    }



    public static void main(String[] args) {

        swapWithThirdVariable(88, 6);
        swapWithoutThirdVariable(993,6562);
        swapUsingXor(132,65);
    }
}
