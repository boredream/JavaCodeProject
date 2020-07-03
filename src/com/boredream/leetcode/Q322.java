package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Q322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }

    static int coinChange(int[] coins, int amount) {
        // 动态规划，dp[] 表示剩余xx钱时，最少可以用多少钱消耗完
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // 每次都尝试从大的开始试，减掉钱以后回头找上一个情境，因为是顺序挨个处理，所以一定会找到对应的
            int minCount = -1;
            for (int j = coins.length - 1; j >= 0; j--) {
                // 计算去掉当前的钱币后，剩多少钱，然后回头dp里找多少钱可以搞定~
                int remain = i - coins[j];
                if (remain >= 0 && dp[remain] != -1){
                    // 有剩余，看剩余钱的是否可以搞定，且多少钱币可以搞定，基于+1
                    int count = dp[remain] + 1;
                    if(count < minCount || minCount == -1) {
                        // 不同硬币可能不同的结果，需要对比
                        minCount = count;
                    }
                }
            }
            dp[i] = minCount;
        }
        return dp[amount];
    }
}
