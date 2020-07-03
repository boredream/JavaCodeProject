package com.boredream.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class Q63uniquePathsWithObstacles {
    public static void main(String[] args) {
    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 同62，依然动态规划，障碍物地方直接dp=0
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        // 直接在原有数组上操作
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = -1;
                } else if (obstacleGrid[i][j] != 1) {
                    int left = i > 0 ? obstacleGrid[i - 1][j] : 0;
                    left = left == 1 ? 0 : left;
                    int right = j > 0 ? obstacleGrid[i][j - 1] : 0;
                    right = right == 1 ? 0 : right;
                    obstacleGrid[i][j] = left + right;
                }
            }
        }
        return -obstacleGrid[m - 1][n - 1];
    }
}
