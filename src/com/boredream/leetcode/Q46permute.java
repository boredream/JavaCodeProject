package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46permute {

    public static void main(String[] args) {
        int[] cadidates = {1, 2, 3};
        System.out.println(permute(cadidates));
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


}
