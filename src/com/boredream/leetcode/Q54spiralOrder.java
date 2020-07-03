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
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder(matrix));
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
}
