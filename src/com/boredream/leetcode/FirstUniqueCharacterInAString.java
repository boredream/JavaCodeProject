package com.boredream.leetcode;

/**
 * 找到第一个非重复字母的索引位置
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "aadadaad";
    }

    /**
     * 思路：判断后续字母中是否包含当前字母用于判断是否有重复的
     * 错误！！！还要考虑之前字母重复的情况
     */
//    static int firstUniqChar(String s) {
//        if(s != null && s.length() == 1) return 0;
//        for (int i = 0; s != null && i < s.toCharArray().length-1; i++) {
//            if(!s.substring(i+1).contains(String.valueOf(s.charAt(i)))) return i;
//        }
//        return -1;
//    }
}
