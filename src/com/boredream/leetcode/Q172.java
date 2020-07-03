package com.boredream.leetcode;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。

 示例 1:

 输入: 3
 输出: 0
 解释: 3! = 6, 尾数中没有零。
 示例 2:

 输入: 5
 输出: 1
 解释: 5! = 120, 尾数中有 1 个零.
 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class Q172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }

    static int trailingZeroes(int n) {
        // logN~ 咋二分？肯定不能真的阶乘，那就On了，要找规律
        // 路过5、10都会产生一个0
        // 那么1~100 一共有多少个x0 和x5的？
        long total = 1;
        for (int i = n; i > 0; i--) {
            total *= i;
            System.out.println(i + " - " + total);
        }

        return n/5;
    }

}
