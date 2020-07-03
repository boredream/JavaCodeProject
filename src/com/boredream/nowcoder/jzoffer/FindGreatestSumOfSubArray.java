package com.boredream.nowcoder.jzoffer;

/**
 * 连续数字最大和
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] array = {-1, -2, -3};
        System.out.println(FindGreatestSumOfSubArray3(array));
    }

    static int FindGreatestSumOfSubArray1(int[] array) {
        // 思路1：因为包含负数，又不确定负数后几个正数补回来。用双指针，
        // 一个是确定会增大的前进指针，一个是在遇到负数后向后探测的指针，一直探测到局部总和>0才前进
        if (array == null || array.length == 0) return 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        int tempSum = 0;
        while (i < array.length && j < array.length) {
            if (array[i] >= 0 && i != j) {
                // 遇到非负数，且当前不是探测前进状态，正常前进。
                sum += array[i++];
                j = i;
            } else {
                // 负数，探测前进
                tempSum += array[j++];
                if (tempSum >= 0) {
                    // 临时累加的数字>=0了，然后前进过去
                    sum += tempSum;
                    i = j;
                    tempSum = 0;
                }
            }
        }
        // 错误，这个思路是必须从开始前进。但可能从半途开始算起连续数字。
        return sum;
    }

    static int FindGreatestSumOfSubArray2(int[] array) {
        // 思路2：基于思路1，但是起始数字加个判断，如果到某个数字时，直接>已有综合sum，则重新开始算
        if (array == null || array.length == 0) return 0;
        int i = 0;
        int sum = 0;
        int tempSum = 0;
        while (i < array.length) {
            if (array[i] >= 0 && tempSum == 0) {
                // 遇到非负数，且当前不是探测前进状态，正常前进。
                sum += array[i++];
            } else {
                // 负数，探测前进
                if (array[i] > sum) {
                    sum = array[i++];
                    tempSum = 0;
                } else {
                    tempSum += array[i++];
                    if (tempSum >= 0) {
                        // 临时累加的数字>=0了，然后前进过去
                        sum += tempSum;
                        tempSum = 0;
                    }
                }
            }
        }
        // 错误，未考虑全部都是负数的情况
        return sum;
    }

    static int FindGreatestSumOfSubArray3(int[] array) {
        // 思路3：基于思路2，对比时，不和0对比，和sum对比
        if (array == null || array.length == 0) return 0;
        int i = 1;
        int sum = array[0];
        int tempSum = 0;
        while (i < array.length) {
            if (array[i] >= 0 && tempSum == 0) {
                // 遇到非负数，且当前不是探测前进状态，正常前进。
                sum += array[i++];
            } else {
                if (array[i] > sum) {
                    sum = array[i++];
                    tempSum = 0;
                } else {
                    // 负数，探测前进
                    tempSum += array[i++];
                    if (tempSum >= 0) {
                        // 临时累加的数字>=0了，然后前进过去
                        sum += tempSum;
                        tempSum = 0;
                    }
                }

            }
        }
        return sum;
    }


}
