package com.boredream.leetcode;

import com.boredream.leetcode.util.Method;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Q215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,3,3,3,3,3,3,3,3}, 1));
    }

    static int findKthLargest(int[] nums, int k) {
        // 经典题目！快排的修改版处理之
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    static int findKthLargest(int[] nums, int start, int end, int k) {
        int lo = start + 1;
        int high = end;
        int compare = nums[start];
        while (true) {
            while (lo < end && nums[lo] <= compare) {
                lo++;
            }
            while (high > start && nums[high] > compare) {
                high--;
            }
            if (lo >= high) break;
            Method.swap(nums, lo, high);
        }
        Method.swap(nums, high, start);
        if (high == nums.length - k) return nums[high];
        else if (high > nums.length - k) return findKthLargest(nums, start, high - 1, k);
        else return findKthLargest(nums, high + 1, end, k);
    }
}
