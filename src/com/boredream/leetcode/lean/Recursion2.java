package com.boredream.leetcode.lean;

import com.boredream.entity.TreeNode;
import com.boredream.leetcode.util.Method;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/
 * 分治算法、回溯、递归对应迭代写法
 */
public class Recursion2 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        System.out.println(new Recursion2().isValidBST(node));
    }

    // 合并排序。分治法。
    public int[] mergeSort(int[] input) {
        if (input.length <= 1) return input;
        int mid = input.length / 2;
        // 不停的二分处理
        int[] left = mergeSort(Arrays.copyOfRange(input, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(input, mid, input.length));
        // 排序合并二分后的数组
        return mergeSort(left, right);
    }

    private int[] mergeSort(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        // 双指针排序新数组
        int retIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                ret[retIndex++] = left[leftIndex++];
            } else {
                ret[retIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            ret[retIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            ret[retIndex++] = right[rightIndex++];
        }
        return ret;
    }

    // 排序。快排基本功。分治的一种，最后不用merge。
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (i <= hi && nums[i] < nums[lo]) i++;
            while (j > lo && nums[j] > nums[lo]) j--;
            if (i >= j) break;
            Method.swap(nums, i, j);
        }
        Method.swap(nums, lo, j);
        sortArray(nums, lo, j - 1);
        sortArray(nums, j + 1, hi);
        // TODO: 2020/8/10 超时？
    }

    // 验证是否是搜索二叉树
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }

}
