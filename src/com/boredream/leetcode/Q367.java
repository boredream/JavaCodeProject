package com.boredream.leetcode;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class Q367 {

    public static void main(String[] args) {
//        for (int i = 0; i < 26; i++) {
//            System.out.println(i + " : " + isPerfectSquare(i));
//        }

        System.out.println(isPerfectSquare(808201));
    }

    static boolean isPerfectSquare(int num) {
        // 挨个遍历效率不行，二分
        // 类似之前思路，在1~num/2里面找，二分先找mid，如果mid * mid < num，则mid作为左边界继续，> 同理
        int lo = 1;
        int high = num / 2 + 1;
        while (lo <= high) {
            int mid = lo + (high - lo) / 2;
            if (Math.pow(mid, 2) == num) return true;
            if (Math.pow(mid, 2) < num) lo = mid + 1;
            else if (Math.pow(mid, 2) > num) high = mid - 1;
        }

        return false;
    }

    static boolean isPerfectSquare2(int num) {
        for (int i = num / 2 + 1; i > 0; i--) {
            if (i * i == num) return true;
        }
        return false;
    }

}
