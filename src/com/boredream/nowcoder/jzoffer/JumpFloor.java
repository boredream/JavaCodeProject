package com.boredream.nowcoder.jzoffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(JumpFloor1(i));
        }
    }

    private static int JumpFloor1(int target) {
        // 思路1：类似斐波那契数列的动态规划问题。因为 最后一次跳，包含一次蹦2和一次蹦1两种跳发，所以fn=fn-1+fn-2
        // 区别在于初始的斐波那契数列是1 1，小青蛙是1 2
        if(target == 0) return 0;
        if(target <= 2) return target;

        int n1 = 2;
        int n2 = 1;
        int total = 0;
        for (int i = 3; i <= target; i++) {
            total = n1 + n2;
            n2 = n1;
            n1 = total;
        }
        return total;
    }

}
