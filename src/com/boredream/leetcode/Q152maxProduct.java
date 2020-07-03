package com.boredream.leetcode;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class Q152maxProduct {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2}));
    }

    static int maxProduct(int[] nums) {
        // dp ij 表示从i一路乘到j的总和，dp[i][j]=dp[i][j-1] * nums[j]
        if (nums == null || nums.length == 0) return 0;
        int max = Math.max(0, nums[0]);
        if (nums.length == 1) return max;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[j];
                } else {
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        // FIXME: 2019/11/14 n^2 ,可以一次循环搞定
        return max;
    }

}
