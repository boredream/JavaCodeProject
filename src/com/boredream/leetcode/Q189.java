package com.boredream.leetcode;

import com.boredream.leetcode.util.Method;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Q189 {

    public static void main(String[] args) {
        System.out.println("[1, 2, 3, 4, 5, 6, 7]");
        for (int i = 1; i < 10; i++) {
            int[] nums = {1, 2, 3, 4, 5, 6, 7};
            rotate2(nums, i); // [5, 6, 7, 1, 2, 3, 4]
            System.out.println(Arrays.toString(nums) + " i = " + i);
        }
    }

    static void rotate(int[] nums, int k) {
        // 后到前 swap 多次
        for (int i = 0; i < k % nums.length; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                Method.swap(nums, j, j - 1);
            }
        }
    }

    static void rotate2(int[] nums, int k) {
        // https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/ FIXME ??
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
