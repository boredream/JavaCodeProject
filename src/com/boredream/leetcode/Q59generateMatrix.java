package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * 4
 * 1  2  3  4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 */
public class Q59generateMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    static int[][] generateMatrix(int n) {
        // 正方形螺旋，数字应该是有规律的
        int[][] matrix = new int[n][n];
        // TODO: 2019/12/26 和54一样，可以优化方向判断switch
        return matrix;
    }

}
