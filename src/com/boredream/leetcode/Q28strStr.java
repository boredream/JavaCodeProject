package com.boredream.leetcode;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * todo KMP算法
 */
public class Q28strStr {

    public static void main(String[] args) {
        System.out.println(strStr1("hello", "ll"));
    }

    static int strStr1(String haystack, String needle) {
        // 思路：可以 On吗？关键在于当发现needle不匹配时，不要一下退到最开始。尝试双指针滑动窗口？
        int start = 0;
        int end = 0;
        while(end < haystack.length()) {
            if(haystack.charAt(end) == needle.charAt(end)) {
                // 如果相等，继续向后遍历
                end ++;
                if(end - start >= needle.length()) {
                    break;
                }
            } else {
                // 如果不相等，end不要直接回退到start+1的地方，让start尽量多前进几步，尝试复用start~end-1之间的数字？怎么做？
            }
        }
        return start;
    }

    static int strStr2(String haystack, String needle) {
        // 思路：遍历，遇到第一个相等的之后挨个找，不对的话，退回第一个相等位置，时间 Omn
        for (int i = 0; i < haystack.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if(match) {
                return i;
            }
        }
        return -1;
    }

}
