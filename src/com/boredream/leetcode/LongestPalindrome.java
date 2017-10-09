package com.boredream.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找字符串里的最长回文组合长度
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 思路：找字符的2倍的字母
     */
    static int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            Integer integer = map.get(s.charAt(i));
            if(integer == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.remove(s.charAt(i));
                count += 2;
            }
        }
        if(map.size() > 0) count ++;
        return count;
    }

}
