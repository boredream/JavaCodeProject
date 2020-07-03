package com.boredream.nowcoder.jzoffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
        };
        System.out.println(printMatrix2(array));
    }

    private static ArrayList<Integer> printMatrix1(int[][] matrix) {
        if (matrix == null) return null;
        // 思路1：用俩指针xy，然后蛇形走位，判断结束点比较麻烦
        return null;
    }

    private static ArrayList<Integer> printMatrix2(int[][] matrix) {
        if (matrix == null) return null;
        // 思路2：先获取层数（环数），然后循环~ 每次循环内四个方向各走一遍
        int row = matrix.length;
        int column = matrix[0].length;
        int layer = (Math.min(row, column) - 1) / 2 + 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < layer; i++) {
            // 左->右
            for (int j = i; j < column - i; j++) result.add(matrix[i][j]);
            // 上->下
            for (int j = i + 1; j < row - i; j++) result.add(matrix[j][column - 1 - i]);
            // 右->左
            for (int j = column - 2 - i; j >= i && row - i - 1 != i; j--) result.add(matrix[row - 1 - i][j]);
            // 下->上
            for (int j = row - 2 - i; j > i && column - i - 1 != i; j--) result.add(matrix[j][i]);
            // TODO: 2019/2/1 这两个 && 很精髓 理解？
        }
        return result;
    }

}
