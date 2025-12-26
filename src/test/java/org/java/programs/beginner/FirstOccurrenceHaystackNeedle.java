package org.java.programs.beginner;

public class FirstOccurrenceHaystackNeedle {

    public static int strStrUsingSubstring(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if(!haystack.isEmpty() && !needle.isEmpty()){
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }

    public static int strStrOptimized(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j;
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needleLength) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int result = strStr(haystack, needle);
        int resultUsingSubstring = strStrUsingSubstring(haystack, needle);
        int resultOptimized = strStrOptimized(haystack, needle);
        System.out.println("First occurrence index: " + result);
        System.out.println("First occurrence index using substring method: " + resultUsingSubstring);
        System.out.println("First occurrence index using optimized method: " + resultOptimized);
    }
}
