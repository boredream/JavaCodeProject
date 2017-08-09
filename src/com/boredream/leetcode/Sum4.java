package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sum4 {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 0, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        for (int i = 0; i < result.size(); i++) {
            for (Integer integer : result.get(i)) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     * 题目：给定一个数组和目标值，计算有多少种数4个字符累加的组合总和为目标值
     * 思考：穷举所有组合？4个数字累加的所有都列出来，和为目标值的记录
     *
     * 可惜。。。算法时间超时
     */
    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 用这个方法 + contain去重
        combination(result, new ArrayList<>(), nums, 4);
        Iterator<List<Integer>> iterator = result.iterator();
        // 只是普通组合算法，要注意去重
        for(;iterator.hasNext();) {
            List<Integer> list = iterator.next();
            int count = 0;
            for (Integer integer : list) {
                count += integer;
            }
            if(count != target) iterator.remove();
        }
        return result;
    }

    static void combination(List<List<Integer>> result, List<Integer> list, int[] ia, int n) {
        if (n == 0) {
            if(!result.contains(list)) result.add(list);
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
                combination(result, nList, ii, n - 1);
            }
        }
    }

}
