package com.boredream.leetcode;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Q32longestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }

    static int longestValidParentheses(String s) {
        // 动态规划题，不一定非要dp[][]=true，任何dp[]/dp[][] int boolean都可以，主要是保存已有子结果
        // 注意顺序方向，一层层的递进，这样后面的可以直接用已有子结果
        // 以及最重要的，找到合适的dp定义
        // 本题可以一次循环，一维dp，用dp[i] = j，表示在i位置时，有j个有效括弧。
        // 则dp[i+1]时，会判断dp[i]是否是有效括弧，是的话，找到夸过dp[i]=j的再左边的是否是匹配括弧，是的话再+2
        // 或者，dp[i+1]时，判断是否和dp[i]凑对，是的话，再累加上dp[i-1]位置的数字
        if(s == null || s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (chars[i - 1] == '(') {
                    int prePreSize = i > 1 ? dp[i - 2] : 0;
                    dp[i] = prePreSize + 2;
                } else {
                    int preSize = dp[i - 1];
                    int skipLeft = i - preSize - 1;
                    if (skipLeft >= 0 && chars[skipLeft] == '(') {
                        int preSkipLeftSize = skipLeft > 0 ? dp[skipLeft - 1] : 0;
                        dp[i] = preSize + dp[skipLeft] + preSkipLeftSize + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }


}
