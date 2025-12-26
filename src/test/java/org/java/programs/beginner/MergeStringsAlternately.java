package org.java.programs.beginner;

/* 1768. Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"   | Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"   | Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 */

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;

        // Alternate adding characters from both strings
        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i++));
            merged.append(word2.charAt(j++));
        }

        // Add any remaining characters from word1
        while (i < word1.length()) {
            merged.append(word1.charAt(i++));
        }

        // Add any remaining characters from word2
        while (j < word2.length()) {
            merged.append(word2.charAt(j++));
        }

        return merged.toString();
    }

    public static String mergeAlternatelyOptimized(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                merged.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                merged.append(word2.charAt(i));
            }
        }

        return merged.toString();
    }



    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        String result = mergeAlternately(word1, word2);
        System.out.println("Merged string: " + result); // Output: "apbqcr"

        String word3 = "ab";
        String word4 = "pqrskkkk";
        String result2 = mergeAlternatelyOptimized(word3, word4);
        System.out.println("Merged string: " + result2); // Output: "apbqrs"

    }
}
