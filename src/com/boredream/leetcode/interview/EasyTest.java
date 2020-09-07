package com.boredream.leetcode.interview;

import java.util.Stack;

public class EasyTest {

    public static void main(String[] args) {
        System.out.println(new EasyTest().maxProfit(new int[]{1,2,3,4,5}));
    }

    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int base = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > base && (i == prices.length - 1 || prices[i] > prices[i + 1])) {
                profit += (prices[i] - base);
                base = Integer.MAX_VALUE;
            } else {
                base = Math.min(base, prices[i]);
            }
        }
        // TODO: 2020/9/7 oN 不限于只是一个循环，可以while到波谷，再while到波峰，计算一次，继续循环
        return profit;
    }
}
