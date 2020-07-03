package com.boredream.leetcode;

/**
 * 打家劫舍2，多个条件，首末位视为相邻
 */
public class Q213rob {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(rob(nums));
    }

    static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 动态规划，dp[i] = dp[i-1] 和 dp[i-2] + nums[i] 里大的那个
        // dp[end] 就是结果。如果取的是i-1还好，如果是包括最后一个，则不能使用第一个
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if(nums.length == 2) return dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        if(dp[nums.length - 1] != dp[nums.length - 2]) {
            // 否则取倒数第一家，还要看第一家有没有打劫
            // 如果是等于，那么最后打劫的是倒数第二家，不会报警。
            if(nums[0] + nums[2] > nums[1]) {
                // 之后看是否打劫了第一家，才会冲突，FIXME 这里判断是否打劫第一家的逻辑不对
                // 考虑去掉第一家还是最后一家。
                // 最后再和倒数第二家重新对比
                dp[nums.length - 1] -= Math.min(nums[0], nums[nums.length - 1]);
                if(dp[nums.length - 2] > dp[nums.length - 1]) {
                    dp[nums.length - 1] = dp[nums.length - 2];
                }
            }
        }
        return dp[nums.length - 1];
    }

}
