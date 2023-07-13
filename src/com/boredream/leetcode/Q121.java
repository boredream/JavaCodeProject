package com.boredream.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 */
public class Q121 {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 1, 6, 8};
        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] prices) {
        // 思路：规则限制不能重新排序；未限制空间；尽量时间On
        // On的话，需要记录买入值，还要记录多个差值赚的钱，咋保存？
        // 依次便利，后一位数字小于前一位，肯定后一位当做买入；
        // 直到遇到下一次下降的情况，但只要下降不超过买入值就不用替换
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 下降，且价格低于买入，则替换买入价
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > prices[i - 1]) {
                // 上升，刷新收益
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }

}
