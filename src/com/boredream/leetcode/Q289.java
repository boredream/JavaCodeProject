package com.boredream.leetcode;

import java.util.Arrays;


/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class Q289 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        gameOfLife(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static void gameOfLife(int[][] board) {
        // 思路：先遍历所有数字，如果当前数字是1，他会影响周围的细胞，所以可以先给一圈细胞记录个临时状态。之后再一轮循环确定数字。
        // 为了让影响数字和原始数字区分开，可以影响数字用10倍数
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] % 10 == 1) {
                    // 更新周围一圈
                    if (i > 0 && j > 0) {
                        board[i - 1][j - 1] += 10;
                    }
                    if (i > 0) {
                        board[i - 1][j] += 10;
                    }
                    if (i > 0 && j < m - 1) {
                        board[i - 1][j + 1] += 10;
                    }
                    if (j < m - 1) {
                        board[i][j + 1] += 10;
                    }
                    if (i < n - 1 && j < m - 1) {
                        board[i + 1][j + 1] += 10;
                    }
                    if (i < n - 1) {
                        board[i + 1][j] += 10;
                    }
                    if (i < n - 1 && j > 0) {
                        board[i + 1][j - 1] += 10;
                    }
                    if (j > 0) {
                        board[i][j - 1] += 10;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean selfIsAlive = board[i][j] % 10 == 1;
                int aroundAliveCount = board[i][j] / 10;
                if((selfIsAlive && (aroundAliveCount == 2 || aroundAliveCount == 3))
                        || (!selfIsAlive && aroundAliveCount == 3)) {
                    // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    board[i][j] = 1;
                } else {
                    // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                    // 本身就是死亡的
                    board[i][j] = 0;
                }
            }
        }
    }

}
