package org.java.programs.beginner;

/* 459. Repeated Substring Pattern
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 * Example 1:
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 *
 * Example 2:
 * Input: s = "aba"
 * Output: false
 * Explanation: It cannot be constructed by any substring.
 *
 * Example 3:
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 */
public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPatternOptimized(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }

    public static boolean repeatedSubstringPatternKMP(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0;
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int len = lps[n - 1];
        return len > 0 && n % (n - len) == 0;
    }

    public static boolean repeatedSubstringPatternRegex(String s) {
        return s.matches("^(\\w+?)\\1+$");
    }


    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "aba";
        String s3 = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s1)); // true
        System.out.println(repeatedSubstringPattern(s2)); // false
        System.out.println(repeatedSubstringPattern(s3)); // true

        System.out.println(repeatedSubstringPatternOptimized(s1)); // true
        System.out.println(repeatedSubstringPatternOptimized(s2)); // false
        System.out.println(repeatedSubstringPatternOptimized(s3)); // true

        System.out.println(repeatedSubstringPatternKMP(s1)); // true
        System.out.println(repeatedSubstringPatternKMP(s2)); // false
        System.out.println(repeatedSubstringPatternKMP(s3)); // true

        System.out.println(repeatedSubstringPatternRegex(s1)); // true
        System.out.println(repeatedSubstringPatternRegex(s2)); // false
        System.out.println(repeatedSubstringPatternRegex(s3)); // true

    }
}
