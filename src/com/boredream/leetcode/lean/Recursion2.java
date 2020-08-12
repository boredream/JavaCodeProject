package com.boredream.leetcode.lean;

import com.boredream.entity.TreeNode;
import com.boredream.leetcode.util.Method;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/
 * 分治算法、回溯、递归对应迭代写法
 */
public class Recursion2 {

    public static void main(String[] args) {
        TreeNode node1 = TreeNode.test();
        TreeNode node2 = TreeNode.testSort();
        System.out.println(new Recursion2().levelOrder(node2));
    }

    ////////////////////////    分治法    ////////////////////////

    // 合并排序。
    public int[] mergeSort(int[] input) {
        if (input.length <= 1) return input;
        int mid = input.length / 2;
        // 不停的二分处理
        int[] left = mergeSort(Arrays.copyOfRange(input, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(input, mid, input.length));
        // 排序合并二分后的数组
        return mergeSort(left, right);
    }

    private int[] mergeSort(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        // 双指针排序新数组
        int retIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                ret[retIndex++] = left[leftIndex++];
            } else {
                ret[retIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            ret[retIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            ret[retIndex++] = right[rightIndex++];
        }
        return ret;
    }

    // 排序。快排基本功。分治的一种，最后不用merge。
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (i <= hi && nums[i] < nums[lo]) i++;
            while (j > lo && nums[j] > nums[lo]) j--;
            if (i >= j) break;
            Method.swap(nums, i, j);
        }
        Method.swap(nums, lo, j);
        sortArray(nums, lo, j - 1);
        sortArray(nums, j + 1, hi);
        // TODO: 2020/8/10 超时？
    }

    // 验证是否是搜索二叉树
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }

    // 2D数组找数字
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // 左下角开始搜，小的向上，大的向右
        return searchMatrix(matrix, target, matrix.length - 1, 0);
    }

    private boolean searchMatrix(int[][] matrix, int target, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return false;
        if (matrix[i][j] == target) return true;
        return matrix[i][j] > target
                ? searchMatrix(matrix, target, i - 1, j)
                : searchMatrix(matrix, target, i, j + 1);
    }

    ////////////////////////    回溯法    ////////////////////////

    // N皇后问题，n的棋盘一共有几种解。回溯法解决。
    public int totalNQueens(int n) {
        // 思路。for循环n行。每次新增都在路线上+1。回溯-1。路线上都=0代表可用。
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 遍历每一行
            for (int j = 0; j < n; j++) {
                // 遍历每一列
                if (board[i][j] == 0) {
                    // 一行中，有一列可以放，米字散开标记 +1
                    int[] dir = {-1, 0, 1};
                    for (int x = 0; x < dir.length; x++) {
                        for (int y = 0; y < dir.length; y++) {
                            setQueenBoard(board, i, j, dir[x], dir[y]);
                        }
                    }
                    break;
                }
            }

            // 如果这行不能放，回溯
            // ...
        }
        // TODO: 2020/8/11 挨个米字扩散浪费时间，可以直接推断当前行的每个位置是否可用
        return 0;
    }

    private void setQueenBoard(int[][] board, int i, int j, int iDiff, int jDiff) {
        // 边界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        // set值
        board[i][j] = 1;

        // 中心点暂时不变
        if (iDiff == 0 && jDiff == 0) {
            return;
        }

        // 有变量的，尾递归下一步
        setQueenBoard(board, i + iDiff, j + jDiff, iDiff, jDiff);
    }

    public int totalNQueens2(int n) {
        totalNQueens2(0, n);
        return count;
    }

    private int count;
    private HashSet<Integer> up = new HashSet<>();
    private HashSet<Integer> upLeft = new HashSet<>();
    private HashSet<Integer> upRight = new HashSet<>();

    private void totalNQueens2(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        // 遍历row行的每一列
        for (int col = 0; col < n; col++) {
            // 竖排
            if (up.contains(col)) continue;
            // 左上斜
            int ul = col - row;
            if (upLeft.contains(ul)) continue;
            // 右上斜
            int ur = col + row;
            if (upRight.contains(ur)) continue;

            // 记录并进行到下一行
            up.add(col);
            upLeft.add(ul);
            upRight.add(ur);
            totalNQueens2(row + 1, n);
            // 回溯
            up.remove(col);
            upLeft.remove(ul);
            upRight.remove(ur);
        }
    }

    // 数独
    public void solveSudoku(char[][] board) {
        // 先把所有行列ban的数字记下来
        HashSet<Character>[] banRow = new HashSet[9];
        HashSet<Character>[] banCol = new HashSet[9];
        HashSet<Character>[] banMatrix = new HashSet[9];
        LinkedList<int[]> empty = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    empty.add(new int[]{i, j});
                    continue;
                }

                // 行
                if (banRow[i] == null) {
                    banRow[i] = new HashSet<>();
                }
                banRow[i].add(c);

                // 列
                if (banCol[j] == null) {
                    banCol[j] = new HashSet<>();
                }
                banCol[j].add(c);

                // 小方块
                int matrixIndex = i / 3 * 3 + j / 3;
                if (banMatrix[matrixIndex] == null) {
                    banMatrix[matrixIndex] = new HashSet<>();
                }
                banMatrix[matrixIndex].add(c);
            }
        }

        HashSet<Character> full = new HashSet<>();
        for (char c : "123456789".toCharArray()) {
            full.add(c);
        }
        fillSudoku(board, banRow, banCol, banMatrix, full, empty);
    }

    private void fillSudoku(char[][] board,
                            HashSet<Character>[] banRow,
                            HashSet<Character>[] banCol,
                            HashSet<Character>[] banMatrix,
                            HashSet<Character> full,
                            LinkedList<int[]> empty) {

        if (empty.size() == 0) {
            // 填完了
            return;
        }

        int[] pop = empty.pop();
        int i = pop[0];
        int j = pop[1];

        // 行列块的ban都不能取
        HashSet<Character> enable = new HashSet<>(full);
        // 行
        enable.removeAll(banRow[i]);
        // 列
        enable.removeAll(banCol[j]);
        // 小方块
        int matrixIndex = i / 3 * 3 + j / 3;
        enable.removeAll(banMatrix[matrixIndex]);

        if (enable.size() == 0) {
            // 没有可以获取的数字，回溯
            board[i][j] = '.';
            empty.addFirst(pop);
        } else {
            for (Character fill : enable) {
                // 从可填内容里填入一条
                board[i][j] = fill;
                // 更新ban列表
                banRow[i].add(fill);
                banCol[j].add(fill);
                banMatrix[matrixIndex].add(fill);
                // 循环到下一个空
                fillSudoku(board, banRow, banCol, banMatrix, full, empty);
                // 回溯
                banRow[i].remove(fill);
                banCol[j].remove(fill);
                banMatrix[matrixIndex].remove(fill);
                // TODO: 2020/8/12 回溯的把重复的也删了，出错。
                // TODO: 2020/8/12 可以不用保存ban集合，每次都实时去获取判断，因为9*9固定的，一次9循环可以判断所有行列块数据
            }
        }
    }

    // 组合。回溯经典实用场景。
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine2(list, new ArrayList<>(), 1, n, k);
        return list;
    }

    private void combine(List<List<Integer>> list, List<Integer> group, int n, int k) {
        if (k == 0) {
            list.add(new ArrayList<>(group));
            return;
        }
        for (Integer i = 1; i <= n; i++) {
            group.add(i);
            combine(list, group, n, k - 1);
            group.remove(i);
        }
        // 排列。组合需要去重。
    }

    private void combine2(List<List<Integer>> list, List<Integer> group, int start, int n, int k) {
        if (k == 0) {
            list.add(new ArrayList<>(group));
            return;
        }
        for (Integer i = start; i <= n; i++) {
            group.add(i);
            // 组合，数字不回头。
            combine2(list, group, i + 1, n, k - 1);
            group.remove(i);
        }
    }

    ////////////////////////    迭代替换递归    ////////////////////////

    // 是否是同一个tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(p);
        list.addLast(q);

        while (!list.isEmpty()) {
            TreeNode pp = list.removeFirst();
            TreeNode qq = list.removeFirst();
            if (pp == null || qq == null || pp.val != qq.val) return false;

            // 双null的不添加
            if (pp.left != null || qq.left != null) {
                list.addLast(pp.left);
                list.addLast(qq.left);
            }
            if (pp.right != null || qq.right != null) {
                list.addLast(pp.right);
                list.addLast(qq.right);
            }

        }
        return true;
    }

    // n组括弧的组合，需要符合规则。
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] p = {'(', ')'};
        int count = n * 2;
        for (int i = 0; i < count; i++) {

        }
        return list;
        // TODO: 2020/8/12 递归无法用回溯法？非回溯法如何解？
    }

    // 左中右，中序，迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.add(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            node = pop.right;
        }
        return list;
    }

    // 层遍历，迭代
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
            }
            list.add(level);
        }
        return list;
    }
}
