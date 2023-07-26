package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Q54spiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(spiralOrder1(matrix));
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        // 列
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;
        // 行
        int startRow = 0;
        int endRow = matrix.length - 1;
        // 方向 0/1/2/3
        int orientation = 0;
        while (startColumn <= endColumn && startRow <= endRow) {
            switch (orientation) {
                case 0:
                    for (int i = startColumn; i <= endColumn; i++) {
                        list.add(matrix[startRow][i]);
                    }
                    startRow++;
                    orientation++;
                    break;
                case 1:
                    for (int i = startRow; i <= endRow; i++) {
                        list.add(matrix[i][endColumn]);
                    }
                    endColumn--;
                    orientation++;
                    break;
                case 2:
                    for (int i = endColumn; i >= startColumn; i--) {
                        list.add(matrix[endRow][i]);
                    }
                    endRow--;
                    orientation++;
                    break;
                case 3:
                    for (int i = endRow; i >= startRow; i--) {
                        list.add(matrix[i][startColumn]);
                    }
                    startColumn++;
                    orientation = 0;
                    break;
            }
        }
        return list;
    }

    static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // 思路：不按箭头顺序插入？不行。List中间插入会影响效率。那还是按箭头顺序
        int row = matrix.length;
        int column = matrix[0].length;
        // 循环N圈
        int circleCount = (Math.min(row, column) + 1) / 2;
        for (int i = 0; i < circleCount; i++) {
            // 每次4个方向循环挨个添加
            int columnCount = column - i * 2;
            int rowCount = row - i * 2;

            // 左到右
            for (int j = i; j < i + columnCount; j++) {
                list.add(matrix[i][j]);
            }
            // 上到下
            for (int j = i + 1; j < i + rowCount; j++) {
                list.add(matrix[j][column - i - 1]);
            }
            // 前俩正向的，都遍历到底，后俩反向的从+1开始，且判断行列数是否>1，防止当前行列只有1的时候数据错误

            // 右到左
            for (int j = i + 1; rowCount > 1 && j < i + columnCount; j++) {
                list.add(matrix[row - i - 1][column - j - 1]);
            }
            // 下到上
            for (int j = i + 1; columnCount > 1 && j < i + rowCount - 1; j++) {
                list.add(matrix[row - j - 1][i]);
            }
        }
        return list;
    }
}
