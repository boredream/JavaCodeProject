package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Q77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> totalList = new ArrayList<>();
        // 思路：回溯 组合
        backTrack(totalList, null, n, k);
        return totalList;
    }

    static void backTrack(List<List<Integer>> totalList, List<Integer> list, int n, int k) {
        if(k == 0) {
            totalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = n; i >= 1; i--) {
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            backTrack(totalList, list, n - 1, k -1);
            list.remove(list.size() - 1);
        }
    }
}
