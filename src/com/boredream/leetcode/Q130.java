package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Q130 {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

//    static void solve(char[][] board) {
//        // 思路1：边界上的不算，则一直O延续到边界上的也不算
//        // dp[][] 表示某位置上true可以延续到边界的O
//        // 先循环四周，所有O的dp[][] = true，且判断O向内一格的如果是O也直接=true，
//        // 然后一圈一圈向里检测，里面圈只判断同圈的情况
//        if (board == null || board.length == 0 || board[0].length == 0) return;
//        int rowCount = board.length;
//        int columnCount = board[0].length;
//        int maxLevel = Math.min((rowCount + 1) / 2, (columnCount + 1) / 2);
//        for (int level = 0; level < maxLevel; level++) {
//            // up
//            for (int i = level; i < board[0].length - level; i++) {
//                System.out.print(board[level][i]);
//            }
//            // down
//            for (int i = level; i < board[0].length - level; i++) {
//                System.out.print(board[board.length - 1 - level][i]);
//            }
//            // left
//            for (int i = level + 1; i < board.length - level - 1; i++) {
//                System.out.print(board[i][level]);
//            }
//            // right
//            for (int i = level + 1; i < board.length - level - 1; i++) {
//                System.out.print(board[i][board[0].length - 1 - level]);
//            }
//        }
//        // FIXME: 2020/1/7 思路错误。其实只要从边界的O开始向内DFS/BFS即可，注意剪枝，这些地方标记下，其他的全换成X
//    }

    static void solve(char[][] board) {
        // 思路：遇到O才开始DFS处理
        // 难点：DFS时是无法修改数据的，需要DFS完之后才可以处理，怎么办？
        // 找规律，只有四边的O连接的O才会保留，其它最终都会变成X
        int m = board.length;
        int n = board[0].length;
        // < 2x2 不会有包裹情况，直接返回
        if (m <= 2 || n <= 2) return;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m) return;
        if (j < 0 || j >= n) return;
        if (board[i][j] != 'O') {
            return;
        }
        // 如果遇到了O，开始延伸，标记为A
        board[i][j] = 'A';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
