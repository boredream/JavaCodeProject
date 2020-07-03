package com.boredream.nowcoder.jzoffer;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,1,2,4,5,7};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // 思路1：HashSet，因为其他都是偶数次，所以利用+1-1的方法都清空。剩下俩就是答案了。
        if (array == null) return;
        HashSet<Integer> set = new HashSet<>();
        for (int i : array) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        if (set.size() < 2) return;
        Iterator<Integer> iterator = set.iterator();
        num1[0] = iterator.next();
        num2[0] = iterator.next();
    }

}
