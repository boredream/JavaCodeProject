package com.boredream.leetcode;

import java.util.HashMap;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 */
public class Q452 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(findMinArrowShots(nums));
    }

    static int findMinArrowShots(int[][] points) {
        // 思路：先用区间end进行排序，然后挨个判断
        // TODO: chunyang 2023/8/3 怎么判断呢？根据官方提示，贪心算法，每一箭都贴着最右侧且尽可能包含最多的气球，就是最佳方案

        return 1;
    }

}
