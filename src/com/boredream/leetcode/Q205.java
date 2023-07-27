package com.boredream.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class Q205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    static boolean isIsomorphic(String s, String t) {
        // 思路：建立俩字符的映射，s、t是任意ASCII字符，就不用数组了，直接hash map
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.get(sc) != null && map.get(sc) != tc) {
                // 映射过，但发现新的情况不相等，则不匹配
                return false;
            }
            if(map.get(sc) == null && set.contains(tc)) {
                // t里被映射的字符，不在map的key里，也代表错位了
                return false;
            }
            map.put(sc, tc);
            set.add(tc);
        }
        return true;

        // TODO: chunyang 2023/7/27 优化，一个hash表即可
    }

}
