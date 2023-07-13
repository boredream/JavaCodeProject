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
 * TODO
 */
public class Q189 {

    public static void main(String[] args) {
        System.out.println("[1, 2, 3, 4, 5, 6, 7]");
        for (int i = 1; i < 10; i++) {
            int[] nums = {1, 2, 3, 4, 5, 6, 7};
            rotate3(nums, i); // [5, 6, 7, 1, 2, 3, 4]
            System.out.println(Arrays.toString(nums) + " i = " + i);
        }

//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        rotate2(nums, 2); // [5, 6, 7, 1, 2, 3, 4]
//        System.out.println(Arrays.toString(nums) + " i = " + 2);
    }

    static void rotate1(int[] nums, int k) {
        // 方案1：暴力，循环k次，每个数字向后挪移一位，最后一个数字放第一位
        for (int round = 0; round < k; round++) {
            int last = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
        }
    }

    static void rotate2(int[] nums, int k) {
        // 思路2：遍历数组，每个数字挨个挪到后k位，那被替换的数字怎么办呢？交换？或者先暂存。先用后者。
        // 因为O1限制，暂存数据也只能是常量个，因此要考虑链式跳k个处理
        // 跳了一圈后，很容易重复，所以要跳多轮，加个判断条件
        int count = nums.length;
        k %= count;

        int start = 0;
        int index = 0;
        int pre = nums[start];
        // 循环count次，完成重新排序
        for (int i = 0; i < count; i++) {
            // index是当前处理数字的真正指针
            index = (index + k) % count;

            // swap 替换相隔k位的数字
            int temp = nums[index];
            nums[index] = pre;
            // 因为是原位替换，所以要借助额外数字pre
            pre = temp;

            if (index == start) {
                // 循环重复了，比如length=8，k=2可能会出现这个情况，第一轮只遍历了0 2 4 6就又回到0
                start ++;
            }
        }
    }

    static void rotate3(int[] nums, int k) {
        // 网上的思路。非常规逻辑类，找到数字的另一种规律，借助倒序的方向
        // [1, 2, 3, 4, 5, 6, 7]
        // [5, 6, 7, 1, 2, 3, 4] k = 3
        // 结果其实可以由 两步搞定 step1 全部倒序 7654321，然后按k分段再各自倒序567 1234
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            Method.swap(nums, start++, end--);
        }
    }

//    static void rotate2(int[] nums, int k) {
//        // https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/ FIXME ??
//        k = k % nums.length;
//        int count = 0;
//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//                count++;
//            } while (start != current);
//        }
//    }

}
