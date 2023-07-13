package com.boredream.leetcode;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i] 
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * TODO 贪心 On
 */
public class Q45 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    static int jump(int[] nums) {
        // 题目在canJump的基础上，希望获取跳到末尾的最小步数，且保证一定可以跳到
        // 思路：倒序，因一定能到末尾，所以先向前遍历到一步可达的最远点？然后重复
        // 算是On2时间复杂度，有待改善
        int step = 0;
        int cur = nums.length - 1;
        while(cur > 0) {
            for (int i = 0; i < cur; i++) {
                // 正序遍历，第一个一步可以到达cur位置的，代表是最远的，记录之
                if(nums[i] + i >= cur) {
                    cur = i;
                    break;
                }
            }
            step ++;
        }
        return step;
    }
}
