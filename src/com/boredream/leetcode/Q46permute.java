package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q46permute {

    public static void main(String[] args) {
        int[] cadidates = {1, 2, 3};
        System.out.println(permute(cadidates));
        System.out.println(permute1(cadidates));
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        // 不定数组合~元素可重复~的回溯法
        append(nums, list, new ArrayList<>(), nums.length);
        return list;
    }

    private static void append(int[] nums, List<List<Integer>> list, ArrayList<Integer> cur, int offset) {
        if (offset == 0) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            append(nums, list, cur, offset - 1);
            cur.remove(cur.size() - 1);
        }
    }

    static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> totalList = new ArrayList<>();
        // 思路：回溯 排列。注意回溯规程去除重复数字，HashSet？
        backStack(totalList, new ArrayList<>(), new HashSet<>(), nums);
        return totalList;
    }

    static void backStack(List<List<Integer>> totalList, List<Integer> list, HashSet<Integer> set, int[] nums) {
        if(list.size() == nums.length) {
            totalList.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if(set.contains(num)) continue;
            list.add(num);
            set.add(num);
            backStack(totalList, list, set, nums);
            list.remove(list.size() - 1);
            set.remove(num);
        }
    }

}
