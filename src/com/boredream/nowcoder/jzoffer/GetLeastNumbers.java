package com.boredream.nowcoder.jzoffer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }

    static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 思路1：直接排序，然后取k位，练习下快速排序
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) return result;
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private static void quickSort(int[] input, int lo, int hi) {
        // 快速排序
        if (lo >= hi) return;
        int j = partition(input, lo, hi);
        quickSort(input, lo, j - 1);
        quickSort(input, j + 1, hi);
    }

    private static int partition(int[] input, int lo, int hi) {
        // 取第一个数字为参照数，然后所有小的放左边，大的放右边
        int i = lo;
        int j = hi + 1;
        int k = input[lo];
        while (true) {
            while (input[++i] < k && i < hi) ;
            while (input[--j] > k && j > lo) ;
            if (i >= j) break;
            exchange(input, i, j);
        }
        exchange(input, lo, j);
        return j;
    }

    private static void exchange(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
