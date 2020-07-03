package com.boredream.nowcoder.jzoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(Permutation("123"));
    }

    private static ArrayList<String> Permutation(String str) {
        // 思路1：经典排列算法 回溯法。递归+交换
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        Permutation(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }

    private static void Permutation(char[] chars, int startIndex, ArrayList<String> result) {
        if (startIndex == chars.length - 1) {
            String str = new String(chars);
            if (!result.contains(str)) result.add(str);
            return;
        }

        // chars不变，根据回溯法，依次使startIndex之前的固定，后面的挨个swap
        for (int i = startIndex; i < chars.length; i++) {
            swap(chars, startIndex, i);
            Permutation(chars, startIndex + 1, result);
            swap(chars, startIndex, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
