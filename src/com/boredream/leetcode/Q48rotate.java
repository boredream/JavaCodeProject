package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class Q48rotate {

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static void rotate(int[][] matrix) {
        // 思路：按圈逐层分为多个正方层，每次单层每个边进行4次轮询替换
        int n = matrix.length;
        int circleCount = n / 2; // 不用+1 因为奇数中心圈就一个数字不用旋转
        for (int i = 0; i < circleCount; i++) {
            // 边长-1个数字
            for (int j = 0; j < n - i * 2 - 1; j++) {
                // 4个边挨个替换
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = matrix[i + j][n - 1 - i];
                matrix[i + j][n - 1 - i] = temp;
            }
        }
    }

}
