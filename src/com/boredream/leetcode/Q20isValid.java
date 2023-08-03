package com.boredream.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有效括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Q20isValid {

    public static void main(String[] args) {
        System.out.println(isValid3("[(])[]{}"));
    }

    static boolean isValid(String s) {
        // 思路1：对称的一对，进入弹出。使用栈
        if (s == null) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && c.equals(map.get(stack.peek()))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    static boolean isValid2(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            Character peek = stack.peek();
            switch (c) {
                // 又括弧的判断能不能结对消去
                case ')':
                    if (peek == '(') stack.pop();
                    else stack.push(peek);
                    break;
                case ']':
                    if (peek == '[') stack.pop();
                    else stack.push(peek);
                    break;
                case '}':
                    if (peek == '{') stack.pop();
                    else stack.push(peek);
                    break;
                default:
                    // 左括弧的全push
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    static boolean isValid3(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左侧括弧随便加，只有右侧括弧添加时需要check
            if (c == '}') {
                if (stack.size() == 0 || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.size() == 0 || stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

}
