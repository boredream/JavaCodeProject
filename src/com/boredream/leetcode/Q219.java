package com.boredream.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q219 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate3(new int[]{1,2,3,1,2,3}, 2));
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 找相等的，同时需要数字+索引信息，第一反应hash map
        // for循环，k-数字，map-索引，>k的跳过，<=k的跳出true
        if (k <= 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer old = map.getOrDefault(nums[i], -1);
            // 有匹配数字
            if (old >= 0) {
                // 有超过 k 就 return true
                if (i - old <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    static boolean containsNearbyDuplicate3(int[] nums, int k) {
        // 思路：hash 保存数字+位置。数字重复怎么办？保存最新的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer old = map.get(nums[i]);
            if(old != null && i - old <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
