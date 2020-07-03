package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q118generate {
    public static void main(String[] args) {
        System.out.println(generate(1));
    }

    static List<List<Integer>> generate(int numRows) {
        // 最原始的算法，按照杨辉自身的规律
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> preRowList = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                if (j == 0 || j == row - 1) {
                    rowList.add(1);
                } else {
                    rowList.add(preRowList.get(j - 1) + preRowList.get(j));
                }
            }
            list.add(rowList);
            preRowList = rowList;
        }
        return list;
    }
}
