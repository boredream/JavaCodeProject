package com.boredream.leetcode;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q395 {

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababacb", 3));
    }

    static int longestSubstring1(String s, int k) {
        // 思路，双指针，慢指针记录符合要求的字母首位，快指针for循环前进
        // 重复字母记录累加数量
        // 遇到非重复字母 或 结束时
        //      如果前面累加数字不到k，则重新将记录指针调到当前
        //      如果前面累加数字到k，指针+，对比记录最大字符串
        int max = 0;
        if(s == null || s.length() == 0 || k > s.length()) return max;

        int start = 0;
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(c == s.charAt(i)) {
                count ++;
            } else {
                if(count < k) {
                    start = i;
                } else {
                    c = s.charAt(i);
                    max = Math.max(max, i - start);
                }
                count = 1;
            }
        }
        // fixme 错，因为不需要连续字母。。。
        return max;
    }

    static int longestSubstring2(String s, int k) {
        // 思路，新建字符数量数组 int[26] 对应a~z，第一轮for循环s，对应字母上累加数量。
        // 第二轮for循环s，去字母表中找，所有数量<k的都视为中断点，以中断点将字符串分为多份，找到最大数
        int maxLength = 0;
        if(s == null || s.length() == 0 || k > s.length()) return maxLength;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] ++;
        }
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if(counts[s.charAt(i) - 'a'] < k) {
                maxLength = Math.max(maxLength, length);
                length = 0;
            } else {
                length ++;
            }
        }
        maxLength = Math.max(maxLength, length);
        // FIXME: 2020/1/13 还是错，是先计算了所有的count，再去找中断；不对，中断拆分的部分不够k~
        return maxLength;
    }

    static int longestSubstring(String s, int k) {
        // 思路，结合1和2的思路，双指针 + 字符数组记录数量，for的时候就计算length问题，每次都check
        int maxLength = 0;
        if(s == null || s.length() == 0 || k > s.length()) return maxLength;
        int[] counts = new int[26];
        int slow = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            counts[s.charAt(fast) - 'a'] ++;
            for (int count : counts) {
                if(count == 0 || count >= k) {

                }
            }
        }
        return maxLength;
    }

}
