package com.boredream.sword2offer;

import java.util.Stack;

public class Test21MinStack {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到校的最小元素的min函数。
     * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
     *
     * @param <T> 泛型参数
     */
    public static class StackWithMin<T extends Comparable<T>> {

        private Stack<T> dataStack;
        private Stack<Integer> minStack;

        private StackWithMin() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        /**
         * 出栈方法
         * @return 栈顶元素
         */
        public T pop() {
            if(dataStack.isEmpty()) return null;
            minStack.pop();
            return dataStack.pop();
        }

        /**
         * 元素入栈
         * @param t 入栈的元素
         */
        public void push(T t) {
            if(t == null) return;
            if(dataStack.isEmpty()) {
                dataStack.push(t);
                minStack.push(0);
            } else {
                // min栈顶是最小数据的position，根据他获取到min数据
                T min = dataStack.get(minStack.peek());
                dataStack.push(t);
                if(t.compareTo(min) < 0) {
                    // 新的数据比之前的min小，则插入新数据的position
                    minStack.push(dataStack.size() - 1);
                } else {
                    // 新数据不比最小的小，则复制最小数据再次加到栈里
                    minStack.push(minStack.peek());
                }

            }
        }

        /**
         * 获取栈中的最小元素
         * @return 栈中的最小元素
         */
        public T min() {
            if(minStack.isEmpty()) return null;
            return dataStack.get(minStack.peek());
        }
    }
    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }

}
