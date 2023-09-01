package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Q17letterCombinations {

    static String[] charmap = {"0", "1", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(letterCombinations("47"));
        System.out.println(letterCombinations3("47"));
    }

    static List<String> letterCombinations(String digits) {
        // 思路1：经典组合题。
        // 其实是一个2-abc 套3-def的3*3=9结果三层循环，但for嵌套数量不确定，所以~ 要用到经典的回溯法
        // 为了方便理解可以转为，3*3的树，然后用前序排列探出每个叶节点，用递归
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        step(list, "", digits);
        return list;
    }

    static void step(List<String> list, String s, String leftDigits) {
        // 获取剩余号码的首数字，解析对应字符
        String strs = charmap[Integer.parseInt(leftDigits.substring(0, 1))];
        // 遍历每个字符，拼接后向下传递
        for (char c : strs.toCharArray()) {
            if (leftDigits.length() == 1) {
                list.add(s + c);
                continue;
            }
            step(list, s + c, leftDigits.substring(1));
        }
    }

    static List<String> letterCombinations2(String digits) {
        // 思路：递归
        List<String> list = new ArrayList<>();
        step2(list, "", digits);
        return list;
    }

    static void step2(List<String> list, String pre, String digits) {
        int startIndex = pre.length();
        int firstNumber = digits.charAt(startIndex) - '0';
        String str = charmap[firstNumber];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String newPre = pre + c;
            if (digits.length() - pre.length() == 1) {
                list.add(newPre);
                continue;
            }
            step2(list, newPre, digits);
        }
    }

    // TODO: chunyang 2023/9/1 普通递归+pre方式，会有多个pre变量，所以内存消耗较大。
    //  要考虑使用回溯，一个StringBuilder，add到叶节点后，再delete回溯到下一个情况

    static List<String> letterCombinations3(String digits) {
        // 思路：回溯
        List<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), digits);
        return list;
    }

    private static void backtrack(List<String> list, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = charmap[digits.charAt(sb.length()) - '0'];
        for (char c : str.toCharArray()) {
            sb.append(c);
            backtrack(list, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
