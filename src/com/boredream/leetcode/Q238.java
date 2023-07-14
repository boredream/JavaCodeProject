package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * todo
 */
public class Q238 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        // 题解：On时间复杂，最简单的是所有数字一轮乘积，二轮除自己，但是限制不能除法
    }

    static int[] productExceptSelf(int[] nums) {
        // 官方题解：左右乘积列表。因为不能除法，所以可以先保存除自己以外其他的乘数，那如何在非n方的情况下每次都排除自己的，正逆序各自保存除自己的左右侧乘积
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        int leftSum = nums[0];
        int rightSum = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = leftSum;
            leftSum *= nums[i];

            int endIndex = nums.length - i - 1;
            right[endIndex] = rightSum;
            rightSum *= nums[endIndex];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
