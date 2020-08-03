package com.boredream.leetcode.lean;

import com.boredream.algorithms.base.Hash;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/
 */
public class QueueAndStack {

    public static void main(String[] args) {
        System.out.println(new QueueAndStack().numSquares(12));
    }

    static class MyCircularQueue {

        private int capacity;
        private int size;
        private int headIndex = -1;
        private int tailIndex = -1;
        private int[] elementData;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            capacity = k;
            elementData = new int[capacity];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            // 满
            if (size >= capacity) return false;
            // tail 尾部插入，结束后尾部向后，注意循环
            if (tailIndex == -1) {
                // 首次插入
                tailIndex = 0;
                headIndex = 0;
            } else {
                tailIndex++;
            }
            if (tailIndex == capacity) tailIndex = 0;
            elementData[tailIndex] = value;
            size++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            // 空
            if (size == 0) return false;
            // head 头部删除，添加是先移动再赋值，删除是先删除再移动
            elementData[headIndex] = -1;
            size--;

            if (size == 0) {
                // 删完了
                headIndex = -1;
                tailIndex = -1;
            } else {
                headIndex++;
                if (headIndex == capacity) headIndex = 0;
            }
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (size == 0) return -1;
            return elementData[headIndex];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (size == 0) return -1;
            return elementData[tailIndex];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }
    }

    // 1陆地、0水。判断有几个岛（连续的上下左右没水or边界的区域）
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    checkWater(grid, i, j);
                    c++;
                }
            }
        }

        return c;
        // TODO: 2020/7/30 全部遍历，遇到1的时候开始向四周 BFS，如果是连接的陆地，继续探同时将此陆地改为已探索状态
    }

    private void checkWater(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        checkWater(grid, i - 1, j);
        checkWater(grid, i + 1, j);
        checkWater(grid, i, j - 1);
        checkWater(grid, i, j + 1);
    }

    // 解锁密码，4个0~9的数字滚轮密码，0000开始，每次滚动1位，不能碰到deadends的情况，最少几步搞定？
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        queue.add("0000");
        visited.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (dead.contains(poll)) continue;
                if (target.equals(poll)) return step;

                for (int index = 0; index < 4; index++) {
                    String s1 = wheel(poll, index, 1);
                    String s2 = wheel(poll, index, -1);
                    if (!visited.contains(s1) && !dead.contains(s1)) {
                        visited.add(s1);
                        queue.add(s1);
                    }
                    if (!visited.contains(s2) && !dead.contains(s2)) {
                        visited.add(s2);
                        queue.add(s2);
                    }
                }
            }
            step++;
        }
        return -1;
        // TODO: 2020/7/31 题目解有点不好理解
    }

    private String wheel(String number, int index, int diff) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (i == index) {
                c += diff;
                if (c > '9') c = '0';
                else if (c < '0') c = '9';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // 最少有几个平方数组成
    public int numSquares(int n) {
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer oldNum = queue.poll();
                for (int j = 1; j * j <= n; j++) {
                    int newNum = oldNum + j * j;
                    if (newNum == n) return count;
                    if (newNum > n) break;
                    if (!visited.contains(newNum)) {
                        visited.add(newNum);
                        queue.add(newNum);
                    }
                }
            }
        }

        return count;
    }

    public int numSquares2(int n) {
        // dp
        if (n <= 0) return 0;
        if (n <= 2) return n;

        // dp[i] = 组成数字i最少要几个平方数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 当前数字回头挨个找平方数差额的地方，找最小的
            for (int j = 1; ; j++) {
                int pre = i - j * j;
                if (pre < 0) break;
                dp[i] = Math.min(dp[i], dp[pre] + 1);
            }
        }
        return dp[n];
    }

}
