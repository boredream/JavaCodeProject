package com.boredream.leetcode;

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * TODO
 */
public class Q76minWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcddcba", "abcdd"));
    }

    static String minWindow2(String s, String t) {
        // 滑动窗口问题~ 双指针处理，先right右移到满足为止，再left优化，一直到不满足继续右移right
        if (s == null || t == null || s.length() == 0 || t.length() > s.length()) return "";
        int left = 0, right = 0;
        String minString = "";
        HashMap<String, Integer> map = new HashMap<>();
        while (right <= s.length() - 1) {
            String rc = String.valueOf(s.charAt(right));
            if (t.contains(rc)) {
                map.put(rc, map.getOrDefault(rc, 0) + 1);
                if (map.size() == t.length()) {
                    // 包含t了，开始优化
                    while (map.size() == t.length()) {
                        String lc = String.valueOf(s.charAt(left));
                        Integer oldNum = map.get(lc);
                        if (oldNum != null) {
                            // 如果包含字母
                            if (oldNum > 1) {
                                // 不止一个的，继续优化
                                map.put(lc, oldNum - 1);
                            } else {
                                map.remove(lc);
                                break;
                            }
                        }
                        left++;
                    }
                    // 只有一个的，删掉后就不满足了，先对比记录，之后再删除
                    if (minString.length() == 0 || right - left < minString.length()) {
                        minString = s.substring(left, right + 1);
                    }
                }
            }
            right++;
        }
        return minString;
    }

    static String minWindow(String s, String t) {
        // 记录最短子串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.get(c1) != null) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1)))
                    match++;
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    // 更新最小子串的位置和长度
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.get(c2) != null) {
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
