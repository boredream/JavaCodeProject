package com.boredream.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 3, 1, 1, 4}));
    }

    static int trap(int[] height) {
        // 思路：第一反应是便利数组，先找到波峰，作为start，然后找到下一个波峰，算中间雨水
        // 但是以上思路有问题，第二个波峰如果过低，其实后面还有个更高的波峰，应该是第一第三波峰直接都是水，咋办呢？
        return 0;
    }
}
