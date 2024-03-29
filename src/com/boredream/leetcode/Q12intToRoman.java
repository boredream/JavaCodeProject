package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 输入数字在1~3999范围内
 */
public class Q12intToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman1(1994));
    }

    static String intToRoman1(int num) {
        // 思路：和13规则一样，反过来
        // 数字从高位到低位，先尽量用大的字母，结合余数和除数，一层层添加字母
        // 对于 IX 这种怎么做？所有情况列出来？
        String[] stringList = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        Integer[] numberList = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int index = numberList.length - 1;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int n = num / numberList[index];
            if(n > 0) {
                // 可以整除，添加字母
                for (int i = n; i > 0; i--) {
                    sb.append(stringList[index]);
                }
                // 减掉转换字母的数字
                num -= n * numberList[index];
            }
            index --;
        }
        return sb.toString();
    }

    static String intToRoman(int num) {
        // 思路1：进制的游戏，但是49这种放左边的比较特殊很蛋疼。
        // 从低位到高位试，判断1459然后插入字符串IVX；然后记录位数，高一位再1459插入XLC一直到M。
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int level = 0;
        while (num > 0) {
            int i = num % 10;
            char c1 = chars[level];
            char c5 = level == 6 ? ' ' : chars[level + 1];
            char c10 = level  == 6 ? ' ' : chars[level + 2];
            if (i == 4) {
                sb.insert(0, "" + c1 + c5);
            } else if (i == 9) {
                sb.insert(0, "" + c1 + c10);
            } else {
                // 1~3 5~8 VIII
                for (int j = 0; j < i % 5; j++) {
                    sb.insert(0, c1);
                }
                if (i >= 5) {
                    sb.insert(0, c5);
                }
            }
            num /= 10;
            level += 2;
        }

        return sb.toString();
    }

}
