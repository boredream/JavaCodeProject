package com.boredream.leetcode.util;

import java.util.TreeMap;

public class Method {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(10, 0);
        map.put(5, 0);
        map.put(15, 0);
        map.put(3, 0);
        map.put(4, 0);
        System.out.println(map);
    }
}
