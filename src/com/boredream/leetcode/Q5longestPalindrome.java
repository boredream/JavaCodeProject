package com.boredream.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 */
public class Q5longestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome3("abcdedcba"));
    }

    private static String longestPalindrome(String s) {
        // 思路1：仨指针，mid递进，每次判断前后位是否相等 or 后一位等于自己，然后从前后位俩pre after指针挨个--++判断是否对称
        if (s == null || s.length() <= 1) return s;

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    private static String longestPalindrome2(String s) {
        // 因为 aba 是回文，所以回文的基础上，两边字母一样也是回文 c aba c，用动态规划的方法~
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   l   r
        // 如果 dp[l, r] = true 那么 dp[l + 1, r - 1] 也一定为 true
        // 关键在这里：[l + 1, r - 1] 一定至少有 2 个元素才有判断的必要
        // 因为如果 [l + 1, r - 1] 只有一个元素，不用判断，一定是回文串
        // 如果 [l + 1, r - 1] 表示的区间为空，不用判断，也一定是回文串
        // [l + 1, r - 1] 一定至少有 2 个元素 等价于 l + 1 < r - 1，即 r - l >  2

        // 写代码的时候这样写：如果 [l + 1, r - 1]  的元素小于等于 1 个，即 r - l <=  2 ，就不用做判断了

        // 因为只有 1 个字符的情况在最开始做了判断
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                // 重点理解 or 的短路性质在这里的作用
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                int length = r - l;
                boolean inner = dp[l + 1][r - 1];
                if (lc == rc && (length <= 2 || inner)) {
                    dp[l][r] = true;
                    if (length + 1 > longestPalindrome) {
                        longestPalindrome = length + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    private static String longestPalindrome3(String s) {
        if (s == null || s.length() <= 1) return s;
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        String result = s.substring(0, 1);
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                boolean sameEdge = s.charAt(l) == s.charAt(r);
                int distance = r - l;
                boolean inner = dp[l + 1][r - 1];
                if (sameEdge && (distance <= 2 || inner)) {
                    dp[l][r] = true;
                    if (distance >= result.length()) {
                        result = s.substring(l, r + 1);
                    }
                }
            }
        }
        return result;
    }

}
