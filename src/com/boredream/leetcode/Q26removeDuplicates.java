package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Q26removeDuplicates {

    public static void main(String[] args) {
        int[] ints = {1,1,2};
        System.out.println(removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
    }

    static int removeDuplicates(int[] nums) {
        // 思路1：排序~ o1空间~
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            }

            nums[i - count] = nums[i];
        }
        return nums.length - count;
    }

}
