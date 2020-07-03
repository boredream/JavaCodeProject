package com.boredream.leetcode;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
 说明：

 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Q347 {
    public static void main(String[] args) {
//        System.out.println(topKFrequent(new int[]{1,1,1,3,2,2}, 2));
        System.out.println(Float.toHexString(1.1f));
        System.out.println(Float.toHexString(1.2f));
        System.out.println(Float.toHexString(1.3f));
        System.out.println(Float.toHexString(1.4f));
        System.out.println();
        System.out.println(Float.toHexString(2.1f));
        System.out.println(Float.toHexString(2.2f));
    }

    static List<Integer> topKFrequent(int[] nums, int k) {
        // n log n  循环套二分
        // 思路1：出现频率，一轮hash n；然后？
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer num : map.keySet()) {
            queue.add(num);
            if (queue.size() > k) queue.poll();
        }

        return new ArrayList<>(queue);
    }
}
