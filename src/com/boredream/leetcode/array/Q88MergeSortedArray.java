package com.boredream.leetcode.array;

import java.util.Arrays;

// 难点在于不使用额外数组。
// 当nums2数字更小放在nums1中，1里面的数字缓存到哪里？
public class Q88MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 思路1：
        // 倒序从后往前，从大到小，挨个放到nums1中，因为1后面本来就是空的，所以挨个顺下来不会冲突，不用暂存数字
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
        }
        // 如果都是1大，顺到后面了，最后还要处理剩余的n。
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
