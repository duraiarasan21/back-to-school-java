package org.java.programs.beginner;

/*
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
 *
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 * Input: s = "IV"
 * Output: 4
 * Explanation: IV = 4.
 *
 * Example 3:
 * Input: s = "IX"
 * Output: 9
 * Explanation: IX = 9.
 *
 * Example 4:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 5:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 */

public class RomanToInteger {
    
    public static int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int value = getValue(ch);

            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }
            prevValue = value;
        }

        return total;
    }
    
    private static int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    
    public static int romanToIntOptimized(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));

            total += (value < prevValue) ? -value : value;
            prevValue = value;
        }

        return total;
    }
    
    public static int romanToIntUsingMap(String s) {
        java.util.Map<Character, Integer> romanMap = new java.util.HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanMap.get(s.charAt(i));

            total += (value < prevValue) ? -value : value;
            prevValue = value;
        }

        return total;
    }
    
    public static int romanToIntUsingArray(String s) {
        int[] romanValues = new int[26];
        romanValues['I' - 'A'] = 1;
        romanValues['V' - 'A'] = 5;
        romanValues['X' - 'A'] = 10;
        romanValues['L' - 'A'] = 50;
        romanValues['C' - 'A'] = 100;
        romanValues['D' - 'A'] = 500;
        romanValues['M' - 'A'] = 1000;

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanValues[s.charAt(i) - 'A'];

            total += (value < prevValue) ? -value : value;
            prevValue = value;
        }

        return total;
    }
    
    public static int romanToIntUsingSwitchBruteforce(String s) {
        int totalSum = 0;
        char[] romanLetters = s.toCharArray();

        for(int i = 0; i < romanLetters.length; i++){
            switch(romanLetters[i]){
                case 'I':
                    totalSum+= 1;
                    break;
                case 'V':
                    if(i !=0 && romanLetters[i - 1] == 'I'){
                        totalSum+= (4-1);
                    } else {
                        totalSum+= 5;
                    }
                    break;
                case 'X':
                    if(i !=0 && romanLetters[i - 1] == 'I'){
                        totalSum+= (9-1);
                    } else if(i < romanLetters.length - 1 && romanLetters[i + 1] == 'I'){
                        totalSum+= 11;
                        i++;
                    } else {
                        totalSum+= 10;
                    }
                    break;
                case 'L':
                    if(i !=0 && romanLetters[i - 1] == 'X'){
                        totalSum+= (40-10);
                    } else if(i < romanLetters.length -1 && romanLetters[i + 1] == 'X'){
                        totalSum+= 60;
                        i++;
                    } else {
                        totalSum+= 50;
                    }
                    break;
                case 'C':
                    if(i !=0 && romanLetters[i - 1] == 'X'){
                        totalSum+= (90-10);
                    } else if(i < romanLetters.length-1 && romanLetters[i + 1] == 'X'){
                        totalSum+= 110;
                        i++;
                    } else {
                        totalSum+= 100;
                    }
                    break;
                case 'D':
                    if(i !=0 && romanLetters[i - 1] == 'C'){
                        totalSum+= (400-100);
                    } else if(i < romanLetters.length-1 && romanLetters[i + 1] == 'C'){
                        totalSum+= 600;
                        i++;
                    } else {
                        totalSum+= 500;
                    }
                    break;
                case 'M':
                    if(i !=0 && romanLetters[i - 1] == 'C'){
                        totalSum+= (900-100);
                    } else if(i < romanLetters.length-1 && romanLetters[i + 1] == 'C'){
                        totalSum+= 1100;
                        i++;
                    } else {
                        totalSum+= 1000;
                    }
                    break;
            }
        }
        return totalSum;
    }
    
    public static void main(String[] args) {
        String romanNumeralOne = "MCMXCIV";
        String romanNumeralTwo = "LVIII";
        String romanNumeralThree = "IX";

        System.out.println(romanToInt(romanNumeralOne));    // Expected output: 1994
        System.out.println(romanToInt(romanNumeralTwo)); // Expected output: 58
        System.out.println(romanToInt(romanNumeralThree)); // Expected output: 9

        System.out.println(romanToIntOptimized(romanNumeralOne));    // Expected output: 1994
        System.out.println(romanToIntOptimized(romanNumeralTwo)); // Expected output: 58
        System.out.println(romanToIntOptimized(romanNumeralThree)); // Expected output: 9

        System.out.println(romanToIntUsingMap(romanNumeralOne));    // Expected output: 1994
        System.out.println(romanToIntUsingMap(romanNumeralTwo)); // Expected output: 58
        System.out.println(romanToIntUsingMap(romanNumeralThree)); // Expected output: 9

        System.out.println(romanToIntUsingArray(romanNumeralOne));    // Expected output: 1994
        System.out.println(romanToIntUsingArray(romanNumeralTwo)); // Expected output: 58
        System.out.println(romanToIntUsingArray(romanNumeralThree)); // Expected output: 9

        System.out.println(romanToIntUsingSwitchBruteforce(romanNumeralOne));    // Expected output: 1994
        System.out.println(romanToIntUsingSwitchBruteforce(romanNumeralTwo)); // Expected output: 58
        System.out.println(romanToIntUsingSwitchBruteforce(romanNumeralThree)); // Expected output: 9
    }
}
