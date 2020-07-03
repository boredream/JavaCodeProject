package com.boredream.nowcoder.jzoffer;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {

    // 思路1：俩字段，一个firstChar，一个HashMap所有字母。重点在于动态的变化firstChar。
    // HashMap如何保证第一个firstChar变成重复后，按顺序取到第二个firstChar呢。
    // 所以使用int[256] 模拟一个Hash结构，因为字符256内有限。且数组可以有序遍历。

    // 对应位置字符默认0代表无数字，1代表有数字，>1代表重复
    private int[] charList = new int[256];
    private StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if (charList[ch] > 1) return;
        charList[ch] = charList[ch] + 1;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char c : sb.toString().toCharArray()) {
            if (charList[c] == 1) {
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce fao = new FirstAppearingOnce();
        StringBuilder sb = new StringBuilder();
        for (char c : "google".toCharArray()) {
            fao.Insert(c);
            sb.append(c);
            System.out.println(sb.toString() + " = " + fao.FirstAppearingOnce());
        }
    }
}
