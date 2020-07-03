package com.boredream.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class Q6Zconvert {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

    static String convert(String s, int numRows) {
        // 思路1：找规律的题目。n行，则下行n个数，回升n-2个数字，然后继续循环下行
        // 所以首行数字应该是 index % (n + n - 2) == 0
        // 次行数字 index % (n + n - 2) == 1 加上 这后面一个上行数字

        if(numRows <= 0) return null;
        if(s == null || s.length() == 0) return s;
        if(numRows == 1 || numRows >= s.length()) return s;

        StringBuilder sb = new StringBuilder();
        for (int level = 0; level < numRows; level++) {
            for (int i = level; i < s.length(); i += (numRows + numRows - 2)) {
                // 每个level的下行字母
                sb.append(s.charAt(i));

                if (level % (numRows - 1) != 0) {
                    // 如果不是第一行or最后一行，还要取上行数字，index = i + (numRows - 1 - level) * 2
                    int nextIndex = i + (numRows - 1 - level) * 2;
                    if (nextIndex < s.length()) {
                        sb.append(s.charAt(nextIndex));
                    }
                }
            }
        }
        return sb.toString();
    }


}
