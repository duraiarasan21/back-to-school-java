package org.java.programs.beginner;

public class ThirdLargestNumber {

    public static int findThirdLargest(int[] numbers){

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        if(numbers == null || numbers.length < 3) {
            throw new IllegalArgumentException("Array must contain at least three elements.");
        }

        for(int number : numbers) {
            if(number > first) {
                third = second;
                second = first;
                first = number;
            } else if(number > second && number != first) {
                third = second;
                second = number;
            } else if(number > third && number != second && number != first) {
                third = number;
            }
        }

        return third;
    }


    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1};
        System.out.println("Third largest number is: " + findThirdLargest(numbers));
    }
}
