package com.boredream.leetcode.common;

/**
 * 组合算法
 */
public class Combination {

    public static void main(String[] args) {
        combination("abc", new StringBuilder(), 2);
    }

    static void combination(String str, StringBuilder sb, int count) {
        if (sb.length() == count) {
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        // 思路是利用递归，依次取字符，然后截取余下的部分，挨个遍历，达到目标数量就保存
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(c);

            combination(str.substring(i + 1), sb, count);
        }
    }
}
