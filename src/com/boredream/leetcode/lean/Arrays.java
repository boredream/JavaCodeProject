package com.boredream.leetcode.lean;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays
 */
public class Arrays {

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(new Arrays().findNumbers(nums));
    }

    // Given a binary array, find the maximum number of consecutive 1s in this array.
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur = 0;
            } else {
                cur++;
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    // Given an array nums of integers, return how many of them contain an even number of digits.
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            // 判断偶数
            // 1: toString.size()
            // 2: 递归 /10
            boolean isEven = false;
            while (num >= 10) {
                num /= 10;
                isEven = !isEven;
            }
            if (isEven) {
                result ++;
            }
        }
        return result;
    }
}
