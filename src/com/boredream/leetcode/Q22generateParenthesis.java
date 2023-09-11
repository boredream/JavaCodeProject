package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Q22generateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis3(3));
    }

    static List<String> generateParenthesis(int n) {
        // 思路1：组合的加强题。回溯的方法，但是简易版，因为只有俩字符。
        // 递归回溯塞左右括弧，但左括弧不能超过n，右括弧不能超过寄几。
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private static void backtrack(List<String> list, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            list.add(cur);
            return;
        }

        if (left < n) {
            backtrack(list, cur + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(list, cur + ")", left, right + 1, n);
        }
    }

    static List<String> generateParenthesis2(int n) {
        // 回溯法，n=3会生成一个6字符串长度的结果，列举所有的
        List<String> result = new ArrayList<>();
        backtrack2(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack2(List<String> list, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            list.add(cur);
            return;
        }
        // 特殊地方在于，去掉符合规则的 () 情况，提炼~ 当前左括弧的数量不能超过总数一半，且一定要>=右括弧的
        if (left < n) backtrack2(list, cur + '(', left + 1, right, n);
        if (right < left) backtrack2(list, cur + ')', left, right + 1, n);
    }

    static List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<>();
        backtrack3(list, new StringBuilder(), n, n);
        return list;
    }

    private static void backtrack3(List<String> list, StringBuilder sb, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            list.add(sb.toString());
            return;
        }

        if (leftCount > 0) {
            sb.append('(');
            backtrack3(list, sb, leftCount - 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightCount > 0 && rightCount > leftCount) {
            sb.append(')');
            backtrack3(list, sb, leftCount, rightCount - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
