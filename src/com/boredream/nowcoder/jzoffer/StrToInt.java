package com.boredream.nowcoder.jzoffer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483648"));
    }

    static int StrToInt(String str) {
        // 思路1：每个字符ASCII转数字，'0'=48 ~ '9'=57
        if (str == null || str.length() == 0) return 0;
        int result = 0;
        int flag = 1; // 1 正数， -1 负数
        int position = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                // 首字母判断正负
                if (c == '+') {
                    position --;
                    continue;
                } else if (c == '-') {
                    position --;
                    flag = -1;
                    continue;
                }
            }

            // 判断是否在0~9之间
            if (c < '0' || c > '9') return 0;
            int num = c - 48;
            if(position > 0) {
                num *= Math.pow(10, position--);
            }
            result += num;
        }
        return result * flag;
    }

}
