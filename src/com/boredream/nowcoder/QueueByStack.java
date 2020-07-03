package com.boredream.nowcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueByStack {

    public static void main(String[] args) {
        // 队列先进先出
        System.out.print("=> ");
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
            queue.offer(i);
        }
        System.out.println();
        System.out.print("<= ");
        for (int i = 1; i < 10; i++) {
            System.out.print(queue.poll() + " ");
        }

        System.out.println();
        System.out.println();

        // 栈先进后出
        System.out.print("=> ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
            stack.push(i);
        }
        System.out.println();
        System.out.print("<= ");
        for (int i = 1; i < 10; i++) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
        System.out.println();

        // 模拟队列
        System.out.print("=> ");
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        System.out.print(sq.pop() + " ");
        sq.push(3);
        System.out.print(sq.pop() + " ");
        System.out.print(sq.pop() + " ");
    }

    public static class StackQueue {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            // 关键是这个判断，在stack2清空后，才重新将stack1里面的导入到2进来
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
