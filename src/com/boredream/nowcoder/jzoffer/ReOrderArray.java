package com.boredream.nowcoder.jzoffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 3, 5, 7};
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reOrderArray1(int[] array) {
        // 思路1：为了不太造额外的空间，在集合内交换，用冒泡排序的方法挨个change？ 不对 PASS
        if (array == null || array.length <= 1) return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // 左偶右奇的时候，再change
                if (array[j - 1] % 2 == 0 && array[j] % 2 == 1) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void reOrderArray2(int[] array) {
        // 思路2：额外一个集合，两次遍历，分别把奇偶数加进去
        if (array == null || array.length <= 1) return;
        int[] sortArray = new int[array.length];
        int index = 0;
        for (int i : array) {
            if (i % 2 == 1) {
                sortArray[index++] = i;
            }
        }
        for (int i : array) {
            if (i % 2 == 0) {
                sortArray[index++] = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = sortArray[i];
        }
    }

}
