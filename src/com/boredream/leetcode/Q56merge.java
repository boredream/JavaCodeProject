package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Q56merge {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 4},
                {2, 3},
        };
        System.out.println(Arrays.deepToString(merge(nums)));
    }

    static int[][] merge(int[][] intervals) {
        // 思路：数组的start进行排序，然后遍历挨个比较当前的end和下一个的start
        if (intervals.length == 1) {
            return intervals;
        }

        // 用left排序
        sort(intervals);
        System.out.println(Arrays.deepToString(intervals));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = list.get(list.size() - 1);
            if (lastInterval[1] >= intervals[i][0]) {
                // 如果上一个区间和当前区间有重叠
                if (intervals[i][1] > lastInterval[1]) {
                    // 且当前区间的end比上个区间的大，则修改上一个区间的end
                    lastInterval[1] = intervals[i][1];
                }
            } else {
                // 如果没有重叠，把当前的区间加入集合
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    private static void sort(int[][] intervals) {
        // 快排
        quickSort(intervals, 0, intervals.length - 1);
    }

    private static void quickSort(int[][] intervals, int start, int end) {
        if (start >= end) {
            return;
        }
        // 第一位作为参考
        int num = intervals[start][0];
        int i = start + 1;
        int j = end;
        while (true) {
            while (i < end && intervals[i][0] <= num) {
                i++;
            }
            while (start < j && intervals[j][0] >= num) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int[] temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;
            i++;
            j--;
        }
        int[] temp = intervals[start];
        intervals[start] = intervals[j];
        intervals[j] = temp;

        quickSort(intervals, start, j - 1);
        quickSort(intervals, j + 1, end);
    }

    static int[][] merge1(int[][] intervals) {
        // 思路：先遍历一遍intervals，找到最大值和最小值，创建这么长一个数组
        // 再遍历一遍intervals，把所有的left和right都加入到长数组中，并且左右的index都进行标记start、end
        // 最后遍历长数组，发现start时开始记录，找到end时更新区间，直到找到下一个start时新建一个区间
        // 因为数字区间不大 0~10000，所以可行
        if (intervals.length == 1) {
            return intervals;
        }
        int min = 10000;
        int max = 0;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        char[] all = new char[max - min + 1];
        for (int[] interval : intervals) {
            all[interval[0] - min] = 'l';
            all[interval[1] - min] = 'r';
        }
        List<int[]> list = new ArrayList<>();
        int[] interval = new int[2];
        for (int i = 0; i < all.length; i++) {

        }
        for (char c : all) {
            if (c == 'l') {

            }
        }
        // FIXME: 2023/8/2 遇到 start=end时 无法处理
        return null;
    }
}
