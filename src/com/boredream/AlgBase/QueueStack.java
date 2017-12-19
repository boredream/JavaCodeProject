package com.boredream.AlgBase;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStack {

    public static void main(String[] args) {
        // 栈，先进后出
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            stack.push(i);
        }
        System.out.println();
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
        System.out.println();

        // 队列，先进先出
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            queue.add(i);
        }
        System.out.println();
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

}
