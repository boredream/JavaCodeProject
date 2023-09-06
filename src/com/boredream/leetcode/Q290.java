package com.boredream.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    static boolean wordPattern(String pattern, String str) {
        // 对应关系，散列表
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (split.length != chars.length) return false;
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> values = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            Character old = map.get(split[i]);
            if (old != null) {
                if (old != chars[i]) return false;
            } else {
                // 如果没找到key，但是values已经有对应的了，也不行，双向绑定
                if (values.contains(chars[i])) return false;
                map.put(split[i], chars[i]);
                values.add(chars[i]);
            }
        }
        return true;
    }

    static boolean wordPattern2(String pattern, String s) {
        String[] as = s.split(" ");
        Map<Character,String> map = new HashMap<>();

        for(int i = 0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i)) == null){
                map.put(pattern.charAt(i),as[i]);
            }else{
                if(!map.get(pattern.charAt(i)).equals(as[i])){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean wordPattern1(String pattern, String s) {
        // 思路：map维护映射关系，但是 不同key 对应同一个value 是错误情况，无法直接判断
        // 所以把value也加入到hash中，加个数字0，这样一定不会和key冲突
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        String[] map = new String[26];
        HashSet<String> values = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (map[index] == null) {
                // 如果key没保存过，保存映射关系
                map[index] = words[i];
                if(values.contains(words[i])) {
                    // 但是value却保存了，单表有俩key映射了同一个value，有问题
                    return false;
                }
                values.add(words[i]);
            } else {
                // key保存过，判断是否相等
                if (!map[index].equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
