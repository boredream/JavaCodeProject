package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Q16threeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    static int threeSumClosest(int[] nums, int target) {
        // 思路1：根据14题的遍历方法，排序+两端指针，在遇到sum=0时直接结束，其他情况对比min值，注意绝对值对比负数情况
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int minDiff = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int first = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + first;
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    // 总和小于target，左指针右移增大，对比记录min
                    if(Math.abs(target - minDiff) > Math.abs(target - sum)) {
                        minDiff = sum;
                    }
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    start++;
                } else {
                    // 总和大于0，右指针左移减小，对比记录min
                    if(Math.abs(target - minDiff) > Math.abs(target - sum)) {
                        minDiff = sum;
                    }
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    end--;
                }
            }
        }
        return minDiff;
    }

}
