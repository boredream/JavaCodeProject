package com.boredream.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class Q64minPathSum {
    public static void main(String[] args) {

    }

    static int minPathSum(int[][] grid) {
        // dp[i][j] += min dp[i-1][j] dp[i][j-1]
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i > 0 || j > 0) {
                    int left = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                    int right = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
                    grid[i][j] += Math.min(left, right);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
