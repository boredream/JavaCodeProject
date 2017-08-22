package com.boredream.leetcode;

import java.util.Map;

/**
 * 题目：Excel中的字母和对应数字的关系，实质上是一个26进制的题目
 * 对应两题，数字转字母和字母转数字
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String s = "CE";
        int number = titleToNumber(s);
        System.out.println(number);
        System.out.println(convertToTitle(number));
    }

    static int titleToNumber(String s) {
        int number = 0;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            // 位数，个位是0，十位是1，依次+1
            int level = s.toCharArray().length - i - 1;
            // 字母代表的数字，A是1，B是2，依次+1
            int num = s.charAt(i) - 64;
            // 综合当前位数和字母代表的实际数字
            int cur = (int) (Math.pow(26, level) * num);
            // 累加
            number += cur;
        }
        return number;
    }

    /**
     * 网上的答案：数字转进制的还是有点迷惑
     */
    static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}
