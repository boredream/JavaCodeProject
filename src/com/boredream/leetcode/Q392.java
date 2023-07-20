package com.boredream.leetcode;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }

    static boolean isSubsequence1(String s, String t) {
        // TODO: chunyang 2023/7/20
        // 进阶：如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
        // 在这种情况下，你会怎样改变代码？
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        // 思路：T不变，S很多，提升整体效率，怎么办？ 从T的数据结构下手？对T预处理
        int sIndex = 0;
        for (int tIndex = 0; tIndex < t.length(); tIndex++) {
            char sc = s.charAt(sIndex);
            char tc = t.charAt(tIndex);
            if(sc == tc) {
                if(sIndex == s.length() - 1) {
                    return true;
                }
                sIndex ++;
            }
        }
        return false;
    }

    static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        // 思路：双指针 Om+n
        int sIndex = 0;
        for (int tIndex = 0; tIndex < t.length(); tIndex++) {
            char sc = s.charAt(sIndex);
            char tc = t.charAt(tIndex);
            if(sc == tc) {
                if(sIndex == s.length() - 1) {
                    return true;
                }
                sIndex ++;
            }
        }
        return false;
    }

}
