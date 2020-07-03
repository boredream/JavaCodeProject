package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class Q34searchRange {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
        int target = 4;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        // 思路，logN，二分查找~ 的变种
        // 先二分找目标
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                // right
                start = mid + 1;
            } else if (nums[mid] > target) {
                // left
                end = mid - 1;
            } else {
                // 命中，再两边扩找边界~
                // 这里继续二分，查左右边界
                getEdge(result, nums, target, start, mid - 1, true);
                getEdge(result, nums, target, mid + 1, end, false);
                break;
            }
        }
        return result;
    }

    private static void getEdge(int[] result, int[] nums, int target, int start, int end, boolean left) {
        // 找边界
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                // right
                start = mid + 1;
            } else if (nums[mid] > target) {
                // left
                end = mid - 1;
            } else {
                // 命中，继续朝原有方向找
                if (left) getEdge(result, nums, target, start, mid - 1, true);
                else getEdge(result, nums, target, mid + 1, end, false);
                return;
            }
        }
        // 到这里后一定是start=end，然后对比target
        if (left) {
            // 如果最后命中，直接返回，否则+1
            result[0] = nums[start] == target ? start : start + 1;
        } else {
            // 同理
            result[1] = nums[end] == target ? end : end - 1;
        }
    }

}
