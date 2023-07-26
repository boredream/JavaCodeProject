package com.boredream.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class Q36 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku2(board));
    }

    static boolean isValidSudoku(char[][] board) {
        // 思路：暴力法？On2
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            // 横排
            HashSet<Character> set1 = new HashSet<>();
            // 竖排
            HashSet<Character> set2 = new HashSet<>();
            for (int j = 0; j < n; j++) {
                char c1 = board[i][j];
                if (c1 != '.') {
                    if (set1.contains(c1)) {
                        return false;
                    }
                    set1.add(c1);
                }

                char c2 = board[j][i];
                if (c2 != '.') {
                    if (set2.contains(c2)) {
                        return false;
                    }
                    set2.add(c2);
                }
            }
        }
        for (int i = 0; i < n / 3; i++) {
            for (int j = 0; j < n / 3; j++) {
                // i,j 代表小九宫格
                HashSet<Character> set = new HashSet<>();
                for (int column = 0; column < 3; column++) {
                    for (int row = 0; row < 3; row++) {
                        char c = board[i * 3 + column][j * 3 + row];
                        if (c != '.') {
                            if (set.contains(c)) {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }
        }
        return true;
    }

    static boolean isValidSudoku2(char[][] board) {
        // 思路：优化，一次循环
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set1 = new HashSet<>();
            HashSet<Character> set2 = new HashSet<>();
            HashSet<Character> set3 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c1 = board[i][j];
                if (c1 != '.') {
                    if (set1.contains(c1)) {
                        return false;
                    }
                    set1.add(c1);
                }

                char c2 = board[j][i];
                if (c2 != '.') {
                    if (set2.contains(c2)) {
                        return false;
                    }
                    set2.add(c2);
                }

                // 先 j 控制九宫格内竖列，0~2 0~2 0~2，所以 j % 3
                // 向右一个九宫格，变成 3~5 循环，所以再 + i
                // 循环3个九宫格后，第4个又回到 0~2，所以 + i % 3
                int column = j % 3 + (i % 3) * 3;
                // 先 j 控制九宫格内横列，000 111 222，所以 j / 3
                // 向右一个九宫格不变，直到第四个九宫格，变成 333 444 555
                int row = j / 3 + (i / 3) * 3;
                char c3 = board[row][column];
                if (c3 != '.') {
                    if (set3.contains(c3)) {
                        return false;
                    }
                    set3.add(c3);
                }
            }
        }
        return true;
    }

    // TODO: chunyang 2023/7/26 优化空间，不用hash set

}
