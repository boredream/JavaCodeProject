package com.boredream.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class Q62uniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(0, 1));
    }

    static int uniquePaths(int m, int n) {
        // 经典的动态规划题目
        // m=列数，遍历用i； n=行数，遍历用j
        // dp[i][j] = 到达当前位置有x种路径，因为只能朝右or下走，所以 当前格子到达方法总数 = 上面格子+左边格子 的到达方法总数
        // 即 dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // 然后遍历顺序？直接双for循环i/j累加即可
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int left = i > 0 ? dp[i - 1][j] : 0;
                    int right = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = left + right;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
