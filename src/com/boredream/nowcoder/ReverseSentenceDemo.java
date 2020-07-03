package com.boredream.nowcoder;

/**
 * “student. a am I”。
 * 句子单词的顺序翻转了，正确的句子应该是“ ”
 */
public class ReverseSentenceDemo {

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }

    static String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(" ");
        if(strings.length <= 1) return str;
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
