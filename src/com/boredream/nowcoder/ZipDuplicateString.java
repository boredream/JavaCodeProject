package com.boredream.nowcoder;

/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 * 若压缩后的字符串没有变短，则返回原先的字符串。
 */
public class ZipDuplicateString {

    public static void main(String[] args) {
        System.out.println(zipString("aabcccccaaa"));
    }

    static String zipString(String iniString) {
        if(iniString == null || iniString.length() == 0) return iniString;
        StringBuilder sb = new StringBuilder();

        char preChar = iniString.charAt(0);
        int count = 1;
        for (int i = 1; i < iniString.length(); i++) {
            char c = iniString.charAt(i);
            if(preChar == c) {
                count ++;
            } else {
                sb.append(preChar).append(count);
                count = 1;
            }
            preChar = c;
        }

        sb.append(preChar).append(count);

        return sb.length() < iniString.length() ? sb.toString() : iniString;
    }

}
