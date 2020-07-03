package com.boredream.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q139 {

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    static boolean wordBreak(String s, List<String> wordDict) {
        // 思路：s从前到后拆，拆开的每部分都能落在list里视为true
        return wordBreak(0, s, wordDict);
    }

    static boolean wordBreak(int start, String s, List<String> wordDict) {
        if (start >= s.length()) {
            // 如果start到这里，代表全部切割完成~ 则没问题
            return true;
        }
        // 思路：s从前到后拆，拆开的每部分都能落在list里视为true
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (wordDict.contains(sub)) {
                // 如果包含，继续剩下的
                boolean lastWordBread = wordBreak(i + 1, s, wordDict);
                // 任意一个不满足，则停止
                if (lastWordBread) return true;
            }
        }
        // FIXME: 2020/1/7 暴力法不可取，遇到 aaaaaaaaaaaaaaaaa + a 的情况时，超时
        return false;
    }

}
