package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */
public class Q57 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {6, 7}, {10, 11}, {12, 16}, {19, 20}, {22, 26}, {28, 30}
        };
        System.out.println(Arrays.deepToString(insert(nums, new int[]{33, 34})));
    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        if (intervals[0][0] > newInterval[1]) {
            list.add(newInterval);
            list.addAll(Arrays.asList(intervals));
            return list.toArray(new int[list.size()][2]);
        }
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            list.addAll(Arrays.asList(intervals));
            list.add(newInterval);
            return list.toArray(new int[list.size()][2]);
        }

        // 思路：有序的，二分查找logN，需要找到最相近的位置，用newInterval的0和数组里的1对比
        // 一般二分查找的命中是根据相等的，区间如何算命中呢？找left的合适插入位置
        int left = 0;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (newInterval[0] <= intervals[mid][1]) {
                right = mid;
            } else if (newInterval[1] > intervals[mid][0]) {
                left = mid + 1;
            }
        }
        // 此时，newInterval的start是刚刚好超过left的区间，然后从这里开始向右尝试合并
        for (int i = 0; i < left; i++) {
            // 先添加不用合并的左侧部分
            list.add(intervals[i]);
        }
        // 尝试合并可能重叠的区域
        if (newInterval[1] < intervals[left][0]) {
            // 新区间的右侧比left位置的区间start还小，直接插入独立区间
            list.add(newInterval);
        } else {
            // 重叠情况
            int[] interval = new int[2];
            // start
            interval[0] = Math.min(newInterval[0], intervals[left][0]);
            // end
            for (; left < intervals.length; left++) {
                // 一直合并到当前区间的start大于newInterval的end为止
                if (intervals[left][0] > newInterval[1]) {
                    break;
                }
                interval[1] = Math.max(intervals[left][1], newInterval[1]);
            }
            list.add(interval);
        }
        for (int i = left; i < intervals.length; i++) {
            // 如果还有剩下的，加上
            list.add(intervals[i]);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
