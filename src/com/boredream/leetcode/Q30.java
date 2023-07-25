package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 和 s 由小写英文字母组成
 */
public class Q30 {

    public static void main(String[] args) {
        System.out.println(findSubstring2("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    static List<Integer> findSubstring(String s, String[] words) {
        // 思路：遍历s，先尝试匹配一个单词，再匹配其它单词，当所有单词都匹配上后，返回结果
        // 所有单词的长度一致，S一定是words单词长度的n倍？要注意利用这个条件
        // 以单词为单位，类似最长不重复子字符串一样滑动窗口解题

        List<Integer> list = new ArrayList<>();
        int start = 0;
        int wordLength = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += wordLength) {
            String matchWord = getMatchWordIndex(s, i, words);

            if (matchWord == null) {
                // 如果接下来的单词不匹配任何单词，则重新开始
                start = i += wordLength;
            } else {
                Integer oldIndex = map.get(matchWord);
                if (oldIndex != null) {
                    // 如果新增的单词重复了，则从start一直删到oldIndex
                    for (; start <= oldIndex; start += wordLength) {
                        String oldMatchWord = getMatchWordIndex(s, start, words);
                        map.remove(oldMatchWord);
                    }
                }
                map.put(matchWord, i);
                if (map.size() == words.length) {
                    // 找到一个结果
                    list.add(start);
                }
            }
        }
        // FIXME 未考虑words中本身有重复单词的情况，且每次getMatchWordIndex都需要遍历单词，时间复杂度较高，把找单词的过程用HashMap优化
        return list;
    }

    static String getMatchWordIndex(String s, int start, String[] words) {
        // 判断 s 中从 start 之后的若干字符，是否和words中任何一个匹配，匹配的话返回
        String sWord = s.substring(start, start + words[0].length());
        for (int i = 0; i < words.length; i++) {
            if (sWord.equals(words[i])) {
                return sWord;
            }
        }
        return null;
    }

    static List<Integer> findSubstring2(String s, String[] words) {
        // 思路：基于上述，找单词用HashMap保存words，且因为可以重复，所以Map的value代表出现次数
        // 且注意，s 不一定是 word.length 的整数
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordCountMap.put(words[i], wordCountMap.getOrDefault(words[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int wordLength = words[0].length();
        HashMap<String, Integer> map = new HashMap<>(wordCountMap);
        for (int i = 0; i < s.length() - wordLength + 1; i++) {
            String word = s.substring(i, i + wordLength);
            if (!wordCountMap.containsKey(word)) {
                // 未匹配单词
                continue;
            }

            // 匹配到单词了
            Integer count = map.get(word);
            if (count == null) {
                // map里为空，代表单词已经匹配到足够数量了，那就从start开始删除
                for (; start <= i; start += wordLength) {
                    if (map.containsKey(word)) {
                        // 直到把当前单词也加回去了，结束
                        count = 1;
                        break;
                    }
                    // 因为start到i之间，一定都是word单词，所以wordLength的步进
                    String startWord = s.substring(start, start + wordLength);
                    // 把单词put回去，相当于把子字符串里的word删除
                    map.put(startWord, map.getOrDefault(startWord, 0) + 1);
                }
            }

            if (count != null) {
                // 如果匹配上单词，从map里移除，移除到0的时候清空key
                if (count > 1) {
                    map.put(word, count - 1);
                } else {
                    map.remove(word);
                    if (map.isEmpty()) {
                        // 清空完了，代表找到一个匹配结果
                        list.add(start);
                    }
                }
            }
        }
        return list;
    }

}
