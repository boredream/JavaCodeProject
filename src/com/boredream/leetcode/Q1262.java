package com.boredream.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1262 {
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[] {1,2,3,4,4}));
    }

    static int maxSumDivThree2(int[] nums) {
        int sum = 0;
        // 3 比较特殊，%3只有0，1，2仨情况，0的直接累加，1、2的俩俩组合即可
        Arrays.sort(nums);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if(num % 3 == 0) {
                sum += num;
                continue;
            }

            if(num % 3 == 1) {
                q1.add(num);
            } else {
                q2.add(num);
            }
            // 如果q1 q2里都有数据，则开始俩俩组合
            if(!q1.isEmpty() && !q2.isEmpty()) {
                sum += (q1.poll() + q2.poll());
            }
        }
        // FIXME: 2020/1/17 不行，可能有俩%3==1组合成%3==2的情况
        return sum;
    }

    static int maxSumDivThree(int[] nums) {
        // dp 表示当前累加数各种模下的累加总数
        int[] dp = new int[3];
        for (int num : nums) {
            int sum0 = dp[0];
            int sum1 = dp[1];
            int sum2 = dp[2];
            if(num % 3 == 2) {
                // + mod0 = mod2
                sum2 = Math.max(dp[2], num + dp[0]);
                // + mod1 = mod0
                sum0 = Math.max(dp[0], num + dp[1]);
                // + mod2 = mod1
                sum1 = Math.max(dp[1], num + dp[2]);
            } else if(num % 3 == 1) {
                // + mod0 = mod1
                sum1 = Math.max(dp[1], num + dp[0]);
                // + mod1 = mod2
                sum2 = Math.max(dp[2], num + dp[1]);
                // + mod2 = mod0
                sum0 = Math.max(dp[0], num + dp[2]);
            } else {
                sum0 += num;
                sum1 += num;
                sum2 += num;
            }
            if(sum0 % 3 == 0) dp[0] = sum0;
            if(sum1 % 3 == 1) dp[1] = sum1;
            if(sum2 % 3 == 2) dp[2] = sum2;

        }
        return dp[0];
    }
}
