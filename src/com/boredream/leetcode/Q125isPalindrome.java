package com.boredream.leetcode;

public class Q125isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abca"));
    }

    static boolean isPalindrome(String s) {
        // 可以一遍循环吗？两端双指针，单指针不行，因为找不到回转点
        if (s == null || s.length() <= 1) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startC = s.charAt(start);
            char endC = s.charAt(end);
            if (startC > 'z' || startC < 'A' || (startC > 'Z' && startC < 'a')) start++;
            else if (endC > 'z' || endC < 'A' || (endC > 'Z' && endC < 'a')) end--;
            else if ((startC - endC) % 32 != 0) return false;
            else {
                start ++;
                end --;
            }
        }
        return true;
    }
}
