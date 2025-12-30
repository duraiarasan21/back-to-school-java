package org.java.programs.beginner;

/* 58. Length of Last Word
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World", with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon", with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy", with length 6.
 *
 */

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] sub = s.split("\\s+");
        int count = 0;

        for(char ch : sub[sub.length - 1].toCharArray()){
            count++;
        }
        return count;
    }

    public static int lengthOfLastWordAlternative(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static int lengthOfLastWordUsingLastIndex(String s) {
        int lastIndex = s.length() - 1;

        // Skip trailing spaces
        while (lastIndex >= 0 && s.charAt(lastIndex) == ' ') {
            lastIndex--;
        }

        int wordEnd = lastIndex;

        // Find the start of the last word
        while (lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            lastIndex--;
        }

        return wordEnd - lastIndex;
    }

    public static int lengthOfLastWordUsingSubstring(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;
    }

    public static int lengthOfLastWordOptimized(String s){
        String trimmedString = s.trim();
        String[] words = trimmedString.split(" ");
        return words[words.length - 1].length();
    }


    public static void main(String[] args) {
        String sOne = "Hello World";
        String sTwo = "   fly me   to   the moon  ";
        String sThree = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(sOne));    // Output: 5
        System.out.println(lengthOfLastWord(sTwo));    // Output: 4
        System.out.println(lengthOfLastWord(sThree));  // Output: 6

        System.out.println(lengthOfLastWordAlternative(sOne));    // Output: 5
        System.out.println(lengthOfLastWordAlternative(sTwo));    // Output: 4
        System.out.println(lengthOfLastWordAlternative(sThree));  // Output: 6

        System.out.println(lengthOfLastWordUsingLastIndex(sOne));    // Output: 5
        System.out.println(lengthOfLastWordUsingLastIndex(sTwo));    // Output: 4
        System.out.println(lengthOfLastWordUsingLastIndex(sThree));  // Output: 6

        System.out.println(lengthOfLastWordUsingSubstring(sOne));    // Output: 5
        System.out.println(lengthOfLastWordUsingSubstring(sTwo));    // Output: 4
        System.out.println(lengthOfLastWordUsingSubstring(sThree));  // Output: 6

        System.out.println(lengthOfLastWordOptimized(sOne));    // Output: 5
        System.out.println(lengthOfLastWordOptimized(sTwo));    // Output: 4
        System.out.println(lengthOfLastWordOptimized(sThree));  // Output: 6
    }
}
