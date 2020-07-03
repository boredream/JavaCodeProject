package com.boredream.nowcoder.jzoffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(FindNumbersWithSum2(array, 12));
    }

    static ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        // 思路1：用HashSet保存，每次用sum减新数字然后去已有里找是否存在。最后自定义比较器排序。
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length < 2) return result;
        return result;
    }

    static ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        // 思路1：因为是递增的，需要乘机越小的话，应该越靠近两端的俩数相乘。所以头尾指针依次遍历，遇到的第一个也就是最外侧的是答案
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length < 2) return result;

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if(array[start] + array[end] == sum) {
                result.add(array[start]);
                result.add(array[end]);
                return result;
            } else if(array[start] + array[end] > sum) {
                // 结果大，右侧的左移以减小
                end --;
            } else {
                start ++;
            }
        }
        return result;
    }

}
