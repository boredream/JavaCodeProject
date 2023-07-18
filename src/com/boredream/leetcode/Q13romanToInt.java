package com.boredream.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class Q13romanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt1("MCMXCIV"));
    }

    static int romanToInt1(String s) {
        // 思路：难点在于 IV 这样 5-1=4 的情况
        // 假如正常左到右遍历，遇到 I，不知道是 1 还是和后面 V结合
        // 那右到左遍历呢，遇到 I，肯定是 1 ，之后遇到大数字先标识下，再遇到小数代表是减法
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int number = map.get(c);
            boolean add = true;
            if (i < s.length() - 1) {
                char rightC = s.charAt(i + 1);
                // TODO: chunyang 2023/7/18 待优化，这一串字符串判断可以优化成按数字大小判断
                if ((c == 'I' && (rightC == 'V' || rightC == 'X'))
                        || (c == 'X' && (rightC == 'L' || rightC == 'C'))
                        || (c == 'C' && (rightC == 'D' || rightC == 'M'))) {
                    add = false;
                }
            }
            if (!add) {
                number = -number;
            }
            sum += number;
        }
        return sum;
    }

    static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        // 思路1：从高位到低位，有个map映射挨个取，注意IV在左的情况优先取这个映射
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        Map<String, Integer> doubleMap = new HashMap<>();
        doubleMap.put("IV", 4);
        doubleMap.put("IX", 9);
        doubleMap.put("XL", 40);
        doubleMap.put("XC", 90);
        doubleMap.put("CD", 400);
        doubleMap.put("CM", 900);

        int num = 0;
        while (s.length() > 0) {
            if (s.length() > 1) {
                String doubleStr = s.substring(0, 2);
                if (doubleMap.containsKey(doubleStr)) {
                    num += doubleMap.get(doubleStr);
                    s = s.replaceFirst(doubleStr, "");
                    continue;
                }
            }

            String singleStr = s.substring(0, 1);
            if (map.containsKey(singleStr)) {
                num += map.get(singleStr);
                s = s.replaceFirst(singleStr, "");
            }
        }

        return num;
    }

}
