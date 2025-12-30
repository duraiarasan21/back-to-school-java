package org.java.programs.beginner;

/* 709. To Lower Case
 * Description:
 * Given a string str, return the string after replacing every uppercase letter with the same lowercase letter.
 *
 * Example 1:
 * Input: str = "HelloWorld!"
 * Output: "helloworld!"
 *
 * Example 2:
 * Input: str = "JAVA programming 123"
 * Output: "java programming 123"
 *
 * Example 3:
 * Input: str = "LeetCode"
 * Output: "leetcode"
 *
 */

public class ToLowerCase {

    public static String toLowerCase(String str) {
        StringBuilder lowerCaseStr = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                // Convert uppercase to lowercase by adding 32
                lowerCaseStr.append((char)(ch + 32));
            } else {
                lowerCaseStr.append(ch);
            }
        }

        return lowerCaseStr.toString();
    }

    public static String toLowerCaseBuiltIn(String str) {
        return str.toLowerCase();
    }

    public static String toLowerCaseUsingASCII(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) { // ASCII range for 'A' to 'Z'
                chars[i] = (char)(chars[i] + 32); // Convert to lowercase
            }
        }

        return new String(chars);
    }

    public static String toLowerCaseUsingStreams(String str) {
        return str.chars()
                  .mapToObj(c -> (char)c)
                  .map(c -> (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c)
                  .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                  .toString();
    }


    public static void main(String[] args) {
        String strOne = "HelloWorld!";
        String strTwo = "JAVA programming 123";
        System.out.println(toLowerCase(strOne)); // Output: helloworld!
        System.out.println(toLowerCase(strTwo)); // Output: java programming 123

        System.out.println(toLowerCaseBuiltIn(strOne)); // Output: helloworld!
        System.out.println(toLowerCaseBuiltIn(strTwo)); // Output: java programming 123

        System.out.println(toLowerCaseUsingASCII(strOne)); // Output: helloworld!
        System.out.println(toLowerCaseUsingASCII(strTwo)); // Output: java programming 123

        System.out.println(toLowerCaseUsingStreams(strOne)); // Output: helloworld!
        System.out.println(toLowerCaseUsingStreams(strTwo)); // Output: java programming 123
    }
}
