package com.boredream.nowcoder.jzoffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {

    public static void main(String[] args) {

    }

    static boolean match(char[] str, char[] pattern) {
        // 思路1：双指针，两边依次判断
        if(str == null && pattern == null) return true;
        if(str == null || pattern == null) return false;

        int strIndex = 0;
        int patternIndex = 0;

        // TODO: 2019/2/13 脑壳晕
        while (strIndex < str.length && patternIndex < pattern.length) {
            if(str[strIndex] == '.') {

            }

        }
        return false;
    }
}
