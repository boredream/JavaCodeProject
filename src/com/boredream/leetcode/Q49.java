package com.boredream.leetcode;

import com.boredream.algorithms.base.Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Q49 {

    public static void main(String[] args) {
        List<List<String>> list = groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        System.out.println(Collections.unmodifiableList(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 思路：最多100个字母，不论顺序，可以获取同一个信息。hash？
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 计算hash
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i).append(',');
            }
            String hash = sb.toString();
            System.out.println(hash);
            List<String> list = map.computeIfAbsent(hash, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
