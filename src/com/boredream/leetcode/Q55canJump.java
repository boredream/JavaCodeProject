package com.boredream.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * TODO
 */
public class Q55canJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,0,0}));
    }

    static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 核心：如果当前索引是之前所有数字都无法达到的，则无法跳到底，否则会走完for循环
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return true;
    }
}
