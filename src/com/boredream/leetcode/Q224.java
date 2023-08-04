package com.boredream.leetcode;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 *
 * TODO 官方解法，因为只有加减没有乘除，因此只要考虑当前一组括弧内的计算结果和括弧最开始的符号是正负即可。
 */
public class Q224 {
    public static void main(String[] args) {
        System.out.println(calculate("2-1+2"));
    }

    static int calculate(String s) {
        // 思路：不同于 1 2 + 这种类计算机的计算栈，例子里是常规逻辑顺序。
        // 每个括弧内要单独计算，这部分需要用到栈，遇到右括弧后一直计算并回退到左括弧
        // 注意特殊点，也就是 -1 和 12 这种多个字符组成的单一元素

        Stack<String> stack = new Stack<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if(((!stack.isEmpty() && "(".equals(stack.peek())) || i == 0) && c == '-') {
                // 如果是起始位置的-，则加入到数字缓存中
                num.append(c);
            } else if (c <= '9' && c >= '0') {
                // 数字
                num.append(c);
            }

            // 如果下一位不是数字了，则num里的当成一个整体数字加入stack
            if (num.length() > 0 && (i == s.length() - 1 || s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0')) {
                stack.add(num.toString());
                num = new StringBuilder();
            }else if (c == ')' || i == s.length() - 1) {
                // 遇到右括弧或结束时开始计算，一直计算到左括弧或开始点
                calculate(stack);
            } else {
                // ( 运算符 单数字
                stack.push(String.valueOf(c));
            }
        }
        if(stack.size() > 1) {
            calculate(stack);
        }
        return Integer.parseInt(stack.pop());
    }

    private static void calculate(Stack<String> stack) {
        int endNum = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            String action = stack.pop();
            if("(".equals(action)) {
                break;
            }
            boolean isAdd = "+".equals(action);
            if (isAdd) {
                endNum = Integer.parseInt(stack.pop()) + endNum;
            } else {
                endNum = Integer.parseInt(stack.pop()) - endNum;
            }
        }
        stack.push(String.valueOf(endNum));
        // FIXME: 2023/8/4 计算方式错误，stack倒着22计算，会先计算后俩，再计算前俩，对于2-1+2的情况，本来应该是1+2=3，会错算为2-3=-1
    }

}
