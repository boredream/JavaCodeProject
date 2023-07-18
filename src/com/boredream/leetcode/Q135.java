package com.boredream.leetcode;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * TODO 要仔细阅读题目，理解，否则会解析偏差
 */
public class Q135 {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(candy(nums));
    }

    private static int candy(int[] ratings) {
        // 思路：找波峰波谷，上升还好，下降怎么办？所以左右两遍循环，只找上升的，只会在波峰冲突，则取大的值
        int[] left = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int total = 0;
        int[] right = new int[ratings.length];
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = 1;
            }
            total += Math.max(left[i], right[i]);
        }
        return total;
    }

}
