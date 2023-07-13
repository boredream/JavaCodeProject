package com.boredream.leetcode;

/**
 * TODO
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Q169MajorityElement {

    public static void main(String[] args) {
        // 思路: 一次循环，记录数字出现次数
        // hash map不行，空间要求不符合。如何利用已有数组空间，或者使用o1空间？
    }

    private static int majorityElement(int[] nums) {
        // 结论，无常规处理方法。使用「摩尔投票法」
        int number = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == number) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    number = nums[i];
                    count = 1;
                }
            }
        }
        return number;
    }

}
