package com.boredream.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Q9isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome1(11));
    }

    static boolean isPalindrome1(int x) {
        // 思路1：字符串方法pass，用数学计算。
        // 最简单的方法是，/ % 挨个数字判断。
        // /= 循环从未到头的取，然后+=*10的重建个反过来的数，最后对比俩是否相等
        if(x < 0) return false;
        if(x < 10) return true;

        int num = x;
        int reverse = 0;
        while (num > 0) {
            int cur = num % 10;
            num /= 10;
            reverse = reverse * 10 + cur;
        }
        return x == reverse;
    }

}
