package com.boredream.leetcode;

import static com.boredream.leetcode.util.Method.swap;

/***
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Q31nextPermutation {

    public static void main(String[] args) {

    }

    static void nextPermutation(int[] nums) {
        // 题目主要是数学角度找规律
        // 从右向左找，第一次发现倒序的（左边的比右边的大），记录该位置，然后回头向右（右边一定是一个倒序数组）找到第一个大于记录值的，
        // 因为是倒序依次递进找到的，所以找到的那个一定是刚刚大于记录值一点点的，交换两者。交换后的右侧依然是倒序，再进行整体reverse操作即可
        if (nums == null || nums.length == 1) return;
        int left = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                left = i;
                break;
            }
        }

        if (left > 0) {
            int right = -1;
            for (int i = left; i < nums.length; i++) {
                if (nums[i] > nums[left]) {
                    right = i;
                    break;
                }
            }
            swap(nums, left, right);
        }
    }

    static void nextPermutation2(int[] nums) {
        // 123 54 6789
        // 从右向左，当发现第一个升序情况时，将


    }
}
