package com.boredream.nowcoder.jzoffer;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,1,3}));
    }

    private static int MoreThanHalfNum_Solution(int[] array) {
        // 思路1：要记录多个数字的数量，感觉时间最少的是用hash，毕竟不同数字不同hash
        if (array == null || array.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, count = 1);
            } else {
                map.put(i, ++count);
            }
            if (count > array.length / 2) {
                return i;
            }
        }

        return 0;
    }

}
