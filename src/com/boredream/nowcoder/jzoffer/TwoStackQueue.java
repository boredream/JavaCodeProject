package com.boredream.nowcoder.jzoffer;

import java.util.Stack;

/**
 * 两个栈攒一个队列（栈先进后出，队列先进先出）
 */
public class TwoStackQueue {

    // 思路1：插入的时候放在s1里，拿出来的时候先让s1所有的都放到s2里，因为先进后出，所以等于倒序了一次，然后从2取，就是最早的一个了。
    //      但是，如果先插入123，则s1从顶到底是321，取，然后s1到s2=123，拿到1。
    //      此时，再插入4，s1=4，s2=23，然后取，4倒腾过去s2=423，取就变成了4~ 不对 PASS

    // 思路2：根据1修改，插入的时候，也先将s2的倒腾回来到s1，然后插入s1顶，取的时候再都到s2，s2的顶取。

    // 思路3：push依然正常直接插入，pop时判断s2的空情况，不同处理~ 只有s2空的时候再从s1倒过去。

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        // 插入的时候，先2倒到1，再1压入
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        // 取的时候，先1倒到2，再2取
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public void push3(int node) {
        stack1.push(node);
    }

    public int pop3() {
        // 取的时候，如果空~ 才先1倒到2，再2取；否则直接取
        if(stack2.isEmpty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.push3(1);
        queue.push3(2);
        System.out.println(queue.pop3());
        queue.push3(3);
        queue.push3(4);
        System.out.println(queue.pop3());
        queue.push3(5);
        System.out.println(queue.pop3());
        System.out.println(queue.pop3());
        System.out.println(queue.pop3());
    }


}
