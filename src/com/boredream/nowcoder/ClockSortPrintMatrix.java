package com.boredream.nowcoder;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4
 *                          5 6 7 8
 *                          9 10 11 12
 *                          13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockSortPrintMatrix {

    public static void main(String[] args) {

    }

    static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return null;
        int x=0, y=0, width=matrix[0].length, height=matrix.length, count=width*height, direct=0;

        ArrayList<Integer> list = new ArrayList<>();
        while(count>0) {
            list.add(x, y);

            count--;
        }
        return list;
    }
}
