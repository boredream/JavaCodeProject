package com.boredream.nowcoder;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStackDemo {


    static class MinStack1 {

        private Stack<Integer> stack = new Stack<>();

        public void push(int node) {
            stack.push(node);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return -1;
        }

        public int min() {
            return -1;
        }
    }
}
