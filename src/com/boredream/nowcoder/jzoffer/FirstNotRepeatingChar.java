package com.boredream.nowcoder.jzoffer;

import java.util.HashMap;

/**
 * 找到第一个只出现一次的字符，返回它的位置
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }

    static int FirstNotRepeatingChar(String str) {
        // 思路1：用HashMap，2n样子复杂度，第一轮循环记录次数，第二轮遍历找数量1的
        // 注意第一次出现~ 所以遍历字符串找，而不是遍历map找
        if (str == null || str.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, 2); // 就不记录具体数字了，统一2，反正没用
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < str.toCharArray().length; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
