package com.boredream.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class Q11maxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        // 思路1：看似双指针。但是左右指针啥时候移动呢？还是要找规则
        // 开始双指针两端，然后每次短的那根移动？
        if (height == null || height.length <= 1) return 0;
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            if (height[end] > height[start]) {
                area = Math.max(area, (end - start) * height[start]);
                start++;
            } else {
                area = Math.max(area, (end - start) * height[end]);
                end--;
            }
        }
        return area;
    }
}
