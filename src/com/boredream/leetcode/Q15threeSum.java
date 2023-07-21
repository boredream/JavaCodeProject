package com.boredream.leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * TODO 双指针，注意去重
 */
public class Q15threeSum {

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1, -1, 0, 1, 2, -1, -4}));
    }

    private static List<List<Integer>> threeSum1(int[] nums) {
        // 思路1：双循环 + map定位
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                int third = -first - second;

                Integer position = map.get(third);
                if (position != null) {
                    // 去重比较麻烦
                    result.add(Arrays.asList(nums[i], nums[j], nums[position]));
                } else {
                    map.put(second, j);
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        // 思路2：先排序，第一层for循环，然后双指针一层遍历的后一位和末一位。遇到重复的跳过不判断
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int first = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + first == 0) {
                    result.add(Arrays.asList(first, nums[start], nums[end]));

                    // 虽然找到一组，但是依然可能还有，所以继续寻找。每次找之前都要去重
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (nums[start] + nums[end] + first < 0) {
                    // 总和小于0，左指针右移增大
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    start++;
                } else {
                    // 总和大于0，右指针左移减小
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    end--;
                }
            }

        }
        return result;
    }

    private static List<List<Integer>> threeSum3(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int mid = 1; mid < nums.length - 1; mid++) {
            // mid指针移动，左右各一个人从两边依次靠近自己，sum<0时左边右移，>0时右边左移
            int left = 0;
            int right = nums.length - 1;

            while (left < mid && right > mid) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum < 0) {
                    while (left < mid && nums[left + 1] == nums[left]) left++;
                    left++;
                } else if (sum > 0) {
                    while (right > mid && nums[right - 1] == nums[right]) right--;
                    right--;
                } else {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    break;
                }
            }
        }

        // FIXME 不行，因为中间值右移重复的时候，无法去重~ 但同理可以用左边的值作为对照值
        return result;
    }

    private static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return result;
        for (int start = 0; start < nums.length - 2; ) {
            if (nums[start] > 0) break;
            int left = start + 1;
            int right = nums.length - 1;

            do {
                int sum = nums[start] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[start], nums[left], nums[right]));
                }

                if (sum <= 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    while (left < right && nums[right] == nums[--right]) ;
                }
            } while (left < right);
            while (start < nums.length - 1 && nums[start] == nums[++start]) ;
        }
        return result;
    }
}
