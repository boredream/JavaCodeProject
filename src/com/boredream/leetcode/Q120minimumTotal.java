package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class Q120minimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
              triangle.add(Arrays.asList(2));
            triangle.add(Arrays.asList(3, 4));
          triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }

    static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size()];
        int min = dp[0] = triangle.get(0).get(0);
        if (triangle.size() == 1) return min;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                // 上一层的相邻结点是当前位置-1 +1的点，取当前最短路径
                if (j == list.size() - 1) {
                    // 最右边，只可能是左上结点过来的
                    dp[j] = list.get(j) + dp[j - 1];
                    if (i == triangle.size() - 1) {
                        min = dp[j];
                    }
                } else if (j == 0) {
                    // 最左边，只可能是右上结点过来的
                    dp[j] = list.get(j) + dp[j];
                } else {
                    dp[j] = list.get(j) + Math.min(dp[j - 1], dp[j]);
                }
                if (i == triangle.size() - 1) {
                    // 最后一层的时候，找到整体最短路径
                    min = Math.min(min, dp[j]);
                }
            }
        }
        return min;
    }

}
