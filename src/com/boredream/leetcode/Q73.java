package com.boredream.leetcode;

import java.util.Arrays;

import static com.boredream.leetcode.util.Method.swap;


/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class Q73 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static void setZeroes(int[][] matrix) {
        // 思路，遍历所有，然后记录所有0位置。再次遍历然后置0
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] nZero = new boolean[n];
        boolean[] mZero = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    nZero[i] = true;
                    mZero[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nZero[i] || mZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
