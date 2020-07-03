package com.boredream.sword2offer;

import java.util.Stack;

public class BuildQueueBy2Stack {

    public static void main(String[] args) {
        MList<Integer> list = new MList<>();
        for (int i = 0; i < 5; i++) {
            list.appendTail(i);
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print(list.deleteHead() + " ");
        }

        System.out.println();
        list.appendTail(1);
        list.appendTail(2);
        list.appendTail(3);
        list.deleteHead();
        list.deleteHead();
        list.appendTail(4);
        list.appendTail(5);

        for (int i = 0; i < 3; i++) {
            System.out.print(list.deleteHead() + " ");
        }
    }

    /**
     * 用两个栈模拟的队列
     * 用两个核实现一个队列。队列的声明如下，诸实现它的两个函数appendTail和deleteHead，
     * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
     */
    public static class MList<T> {
        // 插入栈，只用于插入的数据
        private Stack<T> stack1 = new Stack<>();

        // 弹出栈，只用于弹出数据
        private Stack<T> stack2 = new Stack<>();

        // 添加操作，成在队列尾部插入结点
        public void appendTail(T t) {
            stack1.push(t);
        }

        // 删除操作，在队列头部删除结点
        public T deleteHead() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            if(stack2.isEmpty()) return null;
            return stack2.pop();
        }
    }

}
