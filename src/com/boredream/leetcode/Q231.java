package com.boredream.leetcode;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 */
public class Q231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(218));
    }

    static boolean isPowerOfTwo(int n) {
        // num *= 2不停对比
        if(n <= 0) return false;
        int num = 1;
        while (num < n) {
            num *= 2;
        }
        return n == num;
    }

    static boolean isPowerOfTwo2(int n) {
        while (n % 2 == 0 && n > 0) n /= 2;
        return n == 1;
    }
}
