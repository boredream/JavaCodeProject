package com.boredream.nowcoder;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{1,2,3,3,4,5,6,6,7,8,9}, new int[]{}, new int[]{});
    }

    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // TODO 核心在于使用亦或方法，两个相同数字异或=0，一个数和0异或还是它本身。
        for (int i = 0; i < array.length; i++) {

        }
    }
}
