package com.boredream.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class Q91numDecodings {

    public static void main(String[] args) {
        System.out.println(numDecodings("110"));
    }

//    static int numDecodings(String s) {
//        // 单字母=1种；双字母，<=26时3种，否则2种
//        if (s.length() == 1) return 1;
//
//        int first = 1;
//        int second = (s.charAt(0) - 48) * 10 + (s.charAt(1) - 48) <= 26 ? 2 : 1;
//        for (int i = 2; i < s.length(); i++) {
//            // 最近双字母组成的数字
//            int cur2 = (s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48);
//
//            // 当前位置的最大数量=max(最近一位+之前所有的,最近两位+之前所有的）
//            int firstResult = first + (cur2 <= 26 ? 2 : 1);
//            int secondResult = second + 1;
//            int max = Math.max(firstResult, secondResult);
//
//            // 计算完后，first和second前进1
//            first = second;
//            second = max;
//        }
//        // FIXME 要考虑0的情况
//        return Math.max(first, second);
//    }

    static int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;

        int first = 0;
        int second = 1;
        for (int i = 1; i < s.length(); i++) {
            // 最近双字母组成的数字
            int last = s.charAt(i) - 48;
            int lastPre = s.charAt(i - 1) - 48;

            // 计算最近单双数字各自可以增加的组合数量
            int last1Sum = second;
            int last2Sum = 0;
            if (last == 0 && lastPre == 0) return 0;
            if (last > 0 && lastPre > 0) {
                // 都不是0，则判断是否<=26
                int last2 = lastPre * 10 + last;
                last2Sum = first + (last2 <= 26 ? 2 : 1);
            } else if (lastPre > 0) {
                // 单数字情况，且是x0的结构，01的情况是不能被允许的
                last2Sum = first;
            }
            int max = Math.max(last1Sum, last2Sum);

            // 计算完后，first和second前进1
            first = second;
            second = max;
        }
        // FIXME: 2019/11/14 草拟吗的0！！！！
        return Math.max(first, second);
    }

}
