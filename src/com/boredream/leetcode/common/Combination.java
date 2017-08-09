package com.boredream.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合算法
 */
public class Combination {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        combination(new ArrayList<>(), nums, 3);
    }

    static void combination(List<Integer> list, int[] ia, int n) {
        if (n == 0) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        } else {
            for (int i = 0; i < ia.length - (n - 1); i++) {
                List<Integer> nList = new ArrayList<>();
                nList.addAll(list);
                nList.add(ia[i]);
                // 建立从i开始的子数组
                int[] ii = new int[ia.length - i - 1];
                for (int j = 0; n > 1 && j < ia.length - i - 1; j++) {
                    ii[j] = ia[i + j + 1];
                }
                combination(nList, ii, n - 1);
            }
        }
    }

}
