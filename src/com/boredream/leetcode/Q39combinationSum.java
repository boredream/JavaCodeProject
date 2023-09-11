package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Q39combinationSum {

    public static void main(String[] args) {
        int[] cadidates = {1,2,3};
        int target = 4;
        System.out.println(combinationSum(cadidates, target));
        System.out.println(combinationSum2(cadidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return list;
        // 不定数组合~元素可重复~的回溯法
        append(candidates, list, new ArrayList<>(), 0, 0, target);
        return list;
    }

    private static void append(int[] candidates, List<List<Integer>> list, List<Integer> cur, int curTotal, int start, int target) {
        if(curTotal >= target) {
            if(curTotal == target) list.add(new ArrayList<>(cur));
            // 此时需要回溯
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 添加新元素，然后继续递归
            cur.add(candidates[i]);
            append(candidates, list, cur, curTotal + candidates[i], i, target);
            cur.remove(cur.size() - 1);
        }
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 思路：回溯，数字可以重复用，所以不用考虑剪枝
        List<List<Integer>> totalList = new ArrayList<>();
        backTracking(totalList, new ArrayList<>(), candidates, 0, target);
        return totalList;
    }

    private static void backTracking(List<List<Integer>> totalList, ArrayList<Integer> list, int[] candidates, int startIndex, int target) {
        if(target == 0) {
            totalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            backTracking(totalList, list, candidates, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

}
