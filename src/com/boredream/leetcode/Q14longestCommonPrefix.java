package com.boredream.leetcode;

/**
 * 最长公共前缀
 */
public class Q14longestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{
                "cc",
                "c",
        };
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        // 思路1：一个指针同时在所有字符串前进，挨个判断，直到不相等结束。
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int index = 0;
        for (; ; index++) {
            if (strs[0].length() == 0 || index >= strs[0].length()) break;
            char c = strs[0].charAt(index);
            for (String str : strs) {
                if (str.length() == 0 || index >= str.length()) break;
                if (c != str.charAt(index)) {
                    return str.substring(0, index);
                }
            }
        }
        return strs[0].substring(0, index);
    }

}
