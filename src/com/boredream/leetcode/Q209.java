package com.boredream.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * todo 思路ok，优化写法
 */
public class Q209 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(minSubArrayLen(6, new int[]{10, 2, 3}));
    }

    static int minSubArrayLen(int target, int[] nums) {
        // 思路：滑动窗口，先右指针一直到 > target，然后尝试缩 左指针 直到 < target
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }
        int minLength = nums.length;
        int left = 0;
        int sum = nums[0];
        if(sum >= target) {
            return 1;
        }
        for (int right = 1; right < nums.length; right++) {
            // 右指针累加
            sum += nums[right];

            // 一旦数字达到了，尝试找到最短的长度
            if (sum >= target) {
                // 左指针开始移动，移动到 > target 的最短距离
                while (sum - nums[left] >= target) {
                    sum -= nums[left++];
                }
                // 长度满足了，更新最短距离
                minLength = Math.min(minLength, right - left + 1);
            }
        }
        if(sum < target) {
            minLength = 0;
        }
        return minLength;
    }

}
