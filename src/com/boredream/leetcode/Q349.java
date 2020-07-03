package com.boredream.leetcode;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Q349 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    static int[] intersection2(int[] nums1, int[] nums2) {
        // 滑动窗口问题，重点是不考虑顺序且数字唯一
        int[] longNums = nums1.length >= nums2.length ? nums1 : nums2;
        int[] shortNums = nums1.length >= nums2.length ? nums2 : nums1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : shortNums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 挨个轮，然后丢到散列表里，数字-数量，>0代表交集次数
        for (int i = 0; i < longNums.length - shortNums.length; i++) {
            // 新进入的数字递增数量
            int newNum = longNums[i];
            map.put(newNum, map.getOrDefault(newNum, 0) + 1);
            // i >= short.length 后，把头的数字每次去掉一个
            if (i >= shortNums.length) {
                int oldNum = longNums[i - shortNums.length];
                if (map.containsKey(oldNum)) {
                    map.put(oldNum, map.get(oldNum) - 1);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                set.add(entry.getKey());
            }
        }
        int[] nums = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            nums[i++] = integer;
        }
        // FIXME: 2020/3/20 理解错误，不是计算滑块，只是单纯计算交集
        return nums;
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        // map挨个丢进去

        return new int[2];
    }

}
