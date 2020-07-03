package com.boredream.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Q3LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    private static int lengthOfLongestSubstring(String s) {
        // 思路1：双指针。start指针指向开始无重复计算的首字母，end指针向后挨个遍历判断重复。
        // 用hashMap判断重复，重复时判断记录最大字符串，start指针移动到重复字段后一位，然后end字符串继续。
        if (s == null || s.length() == 0) return 0;
        int start = 0;
        int end = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // 重复时判断记录最大字符串，start指针移动到重复字段后一位，然后end字符串继续。
                start = Math.max(start, map.get(c) + 1); // 关键点在这里，多个字母的时候可能会回退
            }

            max = Math.max(max, end - start + 1);
            map.put(c, end++);
        }
        return max;
    }

    private static int lengthOfLongestSubstring2(String s) {
        // 尽量一轮循环结束，双指针，first、end，first记录数组其实位置，
        // end逐个前进，发现重复（通过hash）数据时，first移到重复位置，对比记录当前最长字符串
        if (s == null || s.length() == 0) return 0;
        int max = 0, first = 0, end = 0;
        HashMap<Character, Integer> charPosition = new HashMap<>();
        char[] chars = s.toCharArray();
        for (end = 0; end < chars.length; end++) {
            char endChar = chars[end];

            Integer sameKeyPosition = charPosition.get(endChar);
            if (sameKeyPosition != null && sameKeyPosition >= first) {
                max = Math.max(end - first, max);
                first = sameKeyPosition + 1;
            }
            charPosition.put(endChar, end);
        }
        max = Math.max(end - first, max);
        return max;
    }

}
