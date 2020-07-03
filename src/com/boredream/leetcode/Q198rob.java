package com.boredream.leetcode;

/**
 * 数组中数字不能连续取，如何找到跳格子路线最大值
 */
public class Q198rob {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    static int rob(int[] nums) {
        // dp[i]表示到i位置时可以获取的最大值。
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        // 有时候为了空间复杂度，不一定要用dp[]，比如这题当前的永远只会用到前俩值
        return dp[nums.length - 1];
    }
}
