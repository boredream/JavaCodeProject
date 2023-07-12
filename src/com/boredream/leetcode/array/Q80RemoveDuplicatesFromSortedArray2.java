package com.boredream.leetcode.array;

import java.util.Arrays;

/**
 * TODO
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Q80RemoveDuplicatesFromSortedArray2 {

    // 关键在于O1的空间复杂，需要同时记录删除后的数组长度，以及作为标记记录数字出现的次数

    public static int removeDuplicates(int[] nums) {
        // 思路1：
        // 双指针， 已经明确是要一个数字保留2个，所以直接和-2位置比即可
        if(nums.length < 2) {
            return nums.length;
        }
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow - 2]) {
                // 只有 fast指针数据和slow的上上个不同才可以赋值给slow位置，且继续前进
                // 因为如果相同的话还赋值，则slow-2 ~ slow就会出现仨一样的数字
                // 当slow+1后，无论此时fast是否和slow相等，都可以进行赋值，因为不会超过仨
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int length = removeDuplicates(nums1);
        System.out.println(Arrays.toString(nums1) + " " + length);
    }

}
