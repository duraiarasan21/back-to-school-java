package org.java.programs.beginner;

import java.time.LocalDate;

public class DayOfWeekFinder {


    public static String findDay(int month, int day, int year) {
        // Zeller's Congruence algorithm to find the day of the week
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int f = day + (13 * (month + 1)) / 5 + k + k / 4 + j / 4 - 2 * j;
        int dayOfWeek = ((f % 7) + 7) % 7; // Ensure non-negative result

        // Map the result to the corresponding day of the week
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[dayOfWeek];
    }

    public static String findDayInBuilt(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public static void main(String[] args) {
        // Example usage
        int month = 8; // August
        int day = 5;   // 5th
        int year = 2023; // Year 2023

        String dayOfWeek = findDay(month, day, year);
        System.out.println("The day of the week is: " + dayOfWeek); // Output: The day of the week is: Saturday
        System.out.println("Using in-built method: " + findDayInBuilt(month, day, year)); // Output: Using in-built method: SATURDAY
    }
}
