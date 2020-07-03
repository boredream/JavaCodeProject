package com.boredream.leetcode;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class Q345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int lo = 0;
        int high = chars.length - 1;
        while (lo < high) {
            while (!isChar(chars[lo]) && lo < high) lo++;
            while (!isChar(chars[high]) && lo < high) high--;
            swap(chars, lo, high);
            lo++;
            high--;
        }
        return new String(chars);
    }

    static boolean isChar(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
