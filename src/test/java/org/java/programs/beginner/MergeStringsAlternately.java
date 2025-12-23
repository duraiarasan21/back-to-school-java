package org.java.programs.beginner;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
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

    public String mergeAlternatelyOptimized(String word1, String word2) {
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
        MergeStringsAlternately merger = new MergeStringsAlternately();
        String word1 = "abc";
        String word2 = "pqr";
        String result = merger.mergeAlternately(word1, word2);
        System.out.println("Merged string: " + result); // Output: "apbqcr"

        String word3 = "ab";
        String word4 = "pqrskkkk";
        String result2 = merger.mergeAlternatelyOptimized(word3, word4);
        System.out.println("Merged string: " + result2); // Output: "apbqrs"

    }
}
