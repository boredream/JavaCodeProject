package com.boredream.leetcode;

public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("aaaaaaSsd"));
    }

    /**
     * 难点在于前两个字母的情况，大小写一共4种组合，后面各种字母也有不同组合，如何更省略的判断
     */
    static boolean detectCapitalUse(String word) {
        if(word.length() == 0) return false;
        boolean isFirstCapitals = word.charAt(0) < 'a'; // 1 大写 2小写
        if(word.length() == 1) return true;
        boolean isSecondCapitals = word.charAt(1) < 'a'; // 1 大写 2小写
        if(!isFirstCapitals && isSecondCapitals) return false;  // 首字母小写，后面字母大写
        for (int i = 2; i < word.toCharArray().length; i++) {
            char c = word.charAt(i);
            if(!isSecondCapitals && c < 'a') return false; // 首字母小写，后面字母大写
            else if(isFirstCapitals && isSecondCapitals && c > 'Z') return false; // 前俩字母大写，后面字母小写
        }
        return true;
    }

    /**
     * 看投票最高的答案，俩思路
     * 一个是用正则~ 字符串匹配的感觉都能正则额
     * 另一个是记录总大写字符数量，然后总的判断，大写的数量为0、和size相等、或只有一个且在最头才算
     */

}
