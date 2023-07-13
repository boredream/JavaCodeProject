package com.boredream.leetcode;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 */
public class Q122 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0};
        System.out.println(maxProfit2(nums));
    }

    private static int maxProfit(int[] prices) {
        // 思路：多次买卖，每个波动都 最低点买入，最高点卖出即可；尽量空间On
        int totalProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 下降，且价格低于买入，则替换买入价
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] >= prices[i - 1]) {
                // 上升，下一个开始下降或者最后一个了（波顶），才卖出
                if (i == prices.length - 1 || prices[i] > prices[i + 1]) {
                    totalProfit += (prices[i] - buy);
                    buy = prices[i];
                }
            }
        }
        return totalProfit;
    }

    private static int maxProfit2(int[] prices) {
        // 优化：遇到下降才判断是波峰，然后卖出，而不是判断当前的和下一个对比
        int totalProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1] || i == prices.length - 1) {
                if (prices[i - 1] > buy) {
                    totalProfit += (prices[i - 1] - buy);
                }
                buy = prices[i];
            }
        }
        return totalProfit;
    }

}
