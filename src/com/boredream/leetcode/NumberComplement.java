package com.boredream.leetcode;

/**
 * Created by lichunyang on 2017/7/12.
 */
public class NumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    private static int findComplement(int num) {
        // 比如5的二进制101
        System.out.println(Integer.toBinaryString(num));

        // highestOneBit是返回最高位为1的二进制数字, 返回值就是100
        int highestOneBit = Integer.highestOneBit(num);
        System.out.println(Integer.toBinaryString(highestOneBit));

        // 左移1位，变成1000
        int leftHighestOneBit = highestOneBit << 1;
        System.out.println(Integer.toBinaryString(leftHighestOneBit));

        // 再减1，就变成了和目标数字一样位长度的全是1的数字，111
        int all1 = leftHighestOneBit - 1;
        System.out.println(Integer.toBinaryString(all1));

        // 最后全1的和目标数字进行^亦或运算，最后就获得了目标答案
        // 亦或的规则是：一样的数字变0，不一样的数字变1，所以和位数对应的全1数字亦或就会得到位都是反过来的数字
        int result = all1 ^ num;
        System.out.println(Integer.toBinaryString(result));

        // return ~num & ((Integer.highestOneBit(num) << 1) - 1);

        return result;
    }
}
