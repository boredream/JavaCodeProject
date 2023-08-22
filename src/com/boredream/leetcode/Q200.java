package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class Q200 {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    static int numIslands(char[][] grid) {
        // 思路：挨个遍历，00位置发散出去，找到所有岛屿。然后10位置如何和00去重呢？
        // 每次发散找到其它岛屿时，修改值1->3，则再次遍历时跳过
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // 遇到1，四周发散
                    recAround(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void recAround(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '3';
            recAround(grid, i - 1, j);
            recAround(grid, i + 1, j);
            recAround(grid, i, j - 1);
            recAround(grid, i, j + 1);
        }
    }

}
