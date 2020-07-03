package com.boredream.leetcode;

import java.util.ArrayList;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class Q7intReverse {

    public static void main(String[] args) {
        System.out.println(reverse3(12345));
    }

    static int reverse1(int x) {
        // 思路1：字符串reverse + Int.parse str 。。。太low
        return x;
    }

    static int reverse2(int x) {
        // 思路2：数学的方法 / % 从高位到低位，然后反过来建立
        // 注意考虑reverse后超过int范围，此时应该返回0
        long num = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while (x >= 10 || x <= -10) {
            int end = x % 10;
            nums.add(end);
            x /= 10;
        }
        nums.add(x);

        for (int i = 0; i < nums.size(); i++) {
            num += nums.get(i) * Math.pow(10, nums.size() - 1 - i);
        }

        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) num = 0;
        return (int) num;
    }

    static int reverse3(int x) {
        // 思路3：和思路2一样，但是不借助list，一次循环中就累加
        long num = 0;
        while (x != 0) {
            int end = x % 10;
            x /= 10;
            num = num * 10 + end;
        }
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) num = 0;
        return (int) num;
    }
}
