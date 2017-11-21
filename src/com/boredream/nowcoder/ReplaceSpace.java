package com.boredream.nowcoder;

/**
 * 替換字符串中的空格成%20
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(s));
    }

    static String replaceSpace(StringBuffer str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) == ' ') {
                str.append("%20");
            } else {
                str.append(str.charAt(i));
            }
        }
        return str.substring(length);
    }
}
