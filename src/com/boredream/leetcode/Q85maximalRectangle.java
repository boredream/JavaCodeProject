package com.boredream.leetcode;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class Q85maximalRectangle {
    public static void main(String[] args) {

    }

    static int maximalRectangle(char[][] matrix) {
        // 子问题拆分，子矩形如果包含0，则再扩一圈只要包含一个1即可。或子矩形包含1，扩一圈全0即可；


        // 如何遍历全部矩形情况？i x j 俩for循环遍历全部起点，再俩for循环找到该起点之后所有的终点
        // dp怎么取？ FIXME
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int startI = 0; startI < m; startI++) {
            for (int startJ = 0; startJ < n; startJ++) {


            }
        }

        return 0;
    }
}
