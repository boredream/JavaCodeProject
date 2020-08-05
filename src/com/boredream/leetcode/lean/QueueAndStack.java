package com.boredream.leetcode.lean;

import com.boredream.entity.GraphNode;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/
 */
public class QueueAndStack {

    public static void main(String[] args) {
        System.out.println(new QueueAndStack().canVisitAllRooms(Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),
                Arrays.asList(0)
        )));
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

    static class MinStack {

        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (min == stack.pop()) min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }

        // TODO: 2020/8/3 pop 后 min会变化
    }

    // 是否对称括弧
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 回头找匹配的
            if (c == ')') {
                if (stack.size() == 0) return false;
                if (stack.pop() != '(') return false;
            } else if (c == ']') {
                if (stack.size() == 0) return false;
                if (stack.pop() != '[') return false;
            } else if (c == '}') {
                if (stack.size() == 0) return false;
                if (stack.pop() != '{') return false;
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    // 多少天后温度会超过今天
    public int[] dailyTemperatures(int[] T) {
//        int[] result = new int[T.length];
//        // 倒着来
//        int max = Integer.MAX_VALUE;
//        for (int i = T.length - 1; i >= 0; i--) {
//            if (T[i] < max) {
//
//            }
//        }
//
//        return result;
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                // 新数据比以前的大，就会回头找对应的数据索引，然后set值
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            // 一直到循环结束，剩下的一定是比当前大的新加入stack，所以栈里是一个递减的数字
            stack.push(i);
        }
        return ret;
        // TODO: 2020/8/4 想不到oN时间的
    }

    // 四则运算栈
    public int evalRPN(String[] tokens) {
        // 除法特殊，回退2 / 回退1
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    // 深拷贝图
    public GraphNode cloneGraph(GraphNode node) {
        GraphNode clone = new GraphNode(node.val);
        HashSet<GraphNode> visited = new HashSet<>();
        cloneGraph(visited, node, clone);
        return clone;
    }

    private void cloneGraph(HashSet<GraphNode> visited, GraphNode node, GraphNode clone) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            GraphNode cloneNeighbor = new GraphNode(neighbor.val);
            clone.neighbors.add(cloneNeighbor);

            cloneGraph(visited, neighbor, cloneNeighbor);
        }
        // TODO: 2020/8/4 visited 访问过应该还是可以访问，要补足邻居
    }

    // 多少种可能+-nums=S
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        findTargetSumWays(nums, S, 0, 0);
        return count;
    }

    private void findTargetSumWays(int[] nums, int S, int cur, int position) {
        if (position == nums.length) {
            if (cur == S) count++;
            return;
        }
        findTargetSumWays(nums, S, cur + nums[position], position + 1);
        findTargetSumWays(nums, S, cur - nums[position], position + 1);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        // TODO: 2020/8/4 上述方法 oN^2 时间复杂度，忒高
        // 牵涉到，重复剪枝问题，应该用dp

        // dp
        // dp[i]代表到S有多少个答案
        // dp[i] = dp[i-1]
        return 0;
    }

    // 栈实现队列
    class StackQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public StackQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        // TODO: 2020/8/5 stack2 非空的时候没必要倒腾
    }

    // 队列实现栈
    class QueueStack {

        Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public QueueStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            // TODO: 2020/8/5 除了新加入的，全部都倒过来
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    // 解码 3[a2[c]] = accaccacc
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            stack.add(c);

            if (Character.isDigit(c) && (i == 0 || !Character.isDigit(s.charAt(i - 1)))) {
                // 开始结算数字，进行循环
                int count = 0;
                while (Character.isDigit(c = stack.pop())) {
                    count = count * 10 + c - '0';
                }

                // 往回找循环内容
                sb = new StringBuilder();
                while (!stack.isEmpty() && (c = stack.pop()) != ']') {
                    if (c == '[') continue;
                    sb.append(c);
                }

                for (int j = 0; j < count; j++) {
                    for (int k = sb.length() - 1; k >= 0; k--) {
                        stack.add(sb.charAt(k));
                    }
                }
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
        // TODO: 2020/8/5 通过。但c每次pop再循环后push回去浪费时间。可以正向循环+stack string解决
    }

    // 将sr、sc坐标的颜色相同链接范围的，都填充为newColor
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 类似找小岛的DSF算法
        if (image[sr][sc] == newColor) return image;
        floodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        floodFill(image, sr - 1, sc, oldColor, newColor);
        floodFill(image, sr + 1, sc, oldColor, newColor);
        floodFill(image, sr, sc - 1, oldColor, newColor);
        floodFill(image, sr, sc + 1, oldColor, newColor);
    }

    // 将非0区域数字都改成和最近0的距离
    public int[][] updateMatrix(int[][] matrix) {
        // BFS，遇到非0时，寻找四周最小数字，然后+1
        // TODO: 2020/8/5 递归结束条件？
        return matrix;
    }

    // 钥匙开门
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> open = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        open.add(0);
        visited.add(0);
        while(!open.isEmpty()) {
            List<Integer> keys = rooms.get(open.poll());
            for (Integer key : keys) {
                if(visited.contains(key)) continue;
                visited.add(key);
                open.add(key);
            }
        }
        return visited.size() == rooms.size();
    }

}

