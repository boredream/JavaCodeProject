package com.boredream.leetcode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q125isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome1("OP"));
    }

    static boolean isPalindrome1(String s) {
        if(s.length() <= 0) {
            return true;
        }
        s = s.toLowerCase();

        // 前后双指针
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            char sc = s.charAt(start);
            char ec = s.charAt(end);
            if(sc < 'a' || sc > 'z') {
                start ++;
            } else if(ec < 'a' || ec > 'z') {
                end --;
            } else {
                if(sc != ec) {
                    return false;
                }
                start ++;
                end --;
            }
        }
        return true;
    }

    static boolean isPalindrome(String s) {
        // 可以一遍循环吗？两端双指针，单指针不行，因为找不到回转点
        if (s == null || s.length() <= 1) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startC = s.charAt(start);
            char endC = s.charAt(end);
            if (startC > 'z' || startC < 'A' || (startC > 'Z' && startC < 'a')) start++;
            else if (endC > 'z' || endC < 'A' || (endC > 'Z' && endC < 'a')) end--;
            else if ((startC - endC) % 32 != 0) return false;
            else {
                start ++;
                end --;
            }
        }
        return true;
    }
}
