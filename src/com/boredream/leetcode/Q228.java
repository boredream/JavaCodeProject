package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class Q228 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }

    static List<String> summaryRanges(int[] nums) {
        // 思路：一次遍历，找中断
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] - nums[i] > 1 || nums[i + 1] - nums[i] < 0) {
                // 如果是最后一个数字，或者下一个数字跳点了，则结束一轮
                if (i == startIndex) {
                    list.add(String.valueOf(nums[i]));
                } else {
                    list.add(String.format("%d->%d", nums[startIndex], nums[i]));
                }
                startIndex = i + 1;
            }
            // 否则继续累加
        }
        return list;
    }
}
