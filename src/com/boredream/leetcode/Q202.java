package com.boredream.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 */
public class Q202 {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    static boolean isHappy(int n) {
        // 思路：拆解数字简单，如何判断重复无限循环？hash？
        HashSet<Integer> num = new HashSet<>();
        while(true) {
            // 提取n的每一位
            int result = 0;
            while(n > 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if(result == 1) {
                return true;
            }

            if(num.contains(result)) {
                return false;
            }
            n = result;
            num.add(n);
        }
    }

}
