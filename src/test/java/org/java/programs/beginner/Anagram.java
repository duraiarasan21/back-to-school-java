package org.java.programs.beginner;

/* 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 */
public class Anagram {

    static {
        for (int i = 0; i < 1001; i++) {
            isAnagram("", "a");
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramUsingSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        java.util.Arrays.sort(sArray);
        java.util.Arrays.sort(tArray);
        return java.util.Arrays.equals(sArray, tArray);
    }

    public static boolean isAnagramUsingHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        java.util.HashMap<Character, Integer> charCountMap = new java.util.HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c);
            }
        }
        return charCountMap.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1)); // true
        System.out.println(isAnagramUsingSorting(s1, t1)); // true
        System.out.println(isAnagramUsingHashMap(s1, t1)); // true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); // false
        System.out.println(isAnagramUsingSorting(s2, t2)); // false
        System.out.println(isAnagramUsingHashMap(s2, t2)); // false

    }
}
