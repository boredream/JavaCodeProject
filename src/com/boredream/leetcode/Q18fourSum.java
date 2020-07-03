package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 */
public class Q18fourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7));
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路1：双for循环+treeSum的方法，难点在于去重处理
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // 前仨相等时，后移
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int preTwo = nums[i] + nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] + preTwo == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                        // 虽然找到一组，但是依然可能还有，所以继续寻找。每次找之前都要去重
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] + preTwo < target) {
                        // 总和小于0，左指针右移增大
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        start++;
                    } else {
                        // 总和大于0，右指针左移减小
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        end--;
                    }
                }
            }
        }
        return result;
    }

}
