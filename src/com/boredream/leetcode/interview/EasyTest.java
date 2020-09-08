package com.boredream.leetcode.interview;

import com.boredream.entity.DataFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class EasyTest {

    public static void main(String[] args) throws Exception {
        int[][] matrix = DataFactory.createMatrix();
        new EasyTest().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int base = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > base && (i == prices.length - 1 || prices[i] > prices[i + 1])) {
                profit += (prices[i] - base);
                base = Integer.MAX_VALUE;
            } else {
                base = Math.min(base, prices[i]);
            }
        }
        // TODO: 2020/9/7 oN 不限于只是一个循环，可以while到波谷，再while到波峰，计算一次，继续循环
        return profit;
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        if (k % nums.length == 0) return;
        k %= nums.length;

        int start = 0;
        int startNum = nums[start];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = (index + (nums.length - k)) % nums.length;
            if (next == start) {
                nums[index] = startNum;
                index = start = ++next;
                startNum = nums[start];
            } else {
                nums[index] = nums[next];
                index = next;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        // 1234567 -> 3 = 567 1234
        // r 4321 r 765
        // r 567 1234

        if (nums == null || nums.length <= 1) return;
        if (k % nums.length == 0) return;
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') continue;

                String row = "r" + i;
                String col = "c" + j;
                String block = "b" + j / 3 + i / 3 * 3;

                HashSet<Character> rowSet = map.computeIfAbsent(row, k -> new HashSet<>());
                if (rowSet.contains(c)) {
                    return false;
                }
                rowSet.add(c);

                HashSet<Character> colSet = map.computeIfAbsent(col, k -> new HashSet<>());
                if (colSet.contains(c)) {
                    return false;
                }
                colSet.add(c);

                HashSet<Character> blockSet = map.computeIfAbsent(block, k -> new HashSet<>());
                if (blockSet.contains(c)) {
                    return false;
                }
                blockSet.add(c);
            }
        }
        return true;
    }

    // 顺时针旋转90度
    public void rotate(int[][] matrix) {
        // 外圈到内圈，每次循环4个数字，走完一排
        int n = matrix.length;
        // TODO: 2020/9/8 圈数是一半的n
        for (int i = 0; i < n / 2; i++) {
            // 每一圈
            for (int j = i; j < n - i - 1; j++) {
                // TODO: 2020/9/8 从x层开始，到n-x层
                // 4个边交换
                int startNum = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = startNum;
            }
        }
    }
}
