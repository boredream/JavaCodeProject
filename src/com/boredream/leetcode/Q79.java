package com.boredream.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Q79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEECCBS"));
    }

    static boolean exist(char[][] board, String word) {
        // 思路：回溯法。挨个扫，扫到第一个字母继续向下尝试，发现所有方向不匹配则回退。注意剪枝
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if(backtracking(board, new boolean[board.length][board[0].length], i, j, word, 0)) return true;
            }
        }
        return false;
    }

    static boolean backtracking(char[][] board, boolean[][] use, int boardX, int boardY, String word, int wordIndex) {
        if (wordIndex == word.length()) return true;
        // 超过边界，回退
        if (boardX < 0 || boardX >= board.length || boardY < 0 || boardY >= board[0].length) return false;
        // 如果当前位置已经探测过，回退
        if (use[boardX][boardY]) return false;
        // 如果当前位置不匹配，回退
        if (board[boardX][boardY] != word.charAt(wordIndex)) return false;

        // 到这里代表当前位置字母匹配，则继续向周围继续探测
        use[boardX][boardY] = true;
        if (backtracking(board, use, boardX - 1, boardY, word, wordIndex + 1)) return true;
        if (backtracking(board, use, boardX, boardY + 1, word, wordIndex + 1)) return true;
        if (backtracking(board, use, boardX + 1, boardY, word, wordIndex + 1)) return true;
        if (backtracking(board, use, boardX, boardY - 1, word, wordIndex + 1)) return true;

        // 都尝试失败，重置use，回退
        use[boardX][boardY] = false;
        return false;
    }

}
