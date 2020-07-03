package com.boredream.nowcoder.jzoffer;

import java.util.ArrayList;

/**
 * 求连续整数和是某个数的组合。比如100 = 9~16 / 18~22
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        for (ArrayList<Integer> arrayList : FindContinuousSequence(100)) {
            System.out.println(arrayList);
        }
    }

    static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 思路1：从1开始累加到某个数，发现再下一位就溢出了，就从开头去减
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int start = 1;
        int end = 1;
        int curSum = 0;
        while (true) {
            if (curSum == sum) {
                // 正好=sum，记录
                ArrayList<Integer> array = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    array.add(i);
                }
                if(array.size() > 1) result.add(array);
                curSum -= start++;
            } else if (curSum > sum) {
                // >sum，然后从前面start开始减
                curSum -= start++;
            } else {
                // <sum，继续累加end
                curSum += end++;
            }

            if (start >= end && end >= sum) break;
        }

        return result;
    }

}
