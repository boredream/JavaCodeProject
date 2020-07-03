package com.boredream.nowcoder.jzoffer;

import java.util.Arrays;

/**
 * 一副牌，多大小王，一共56张牌 （1~10jqk）* 4 + 2*大王 + 2*小王。
 * 其中jqk看做11 12 13，大小王可以抵任何牌。
 * 求抽出五张牌（numbers[]数组，其中0代表大小王）是否可以组成顺子。
 */
public class IsContinuous {

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{1}));
    }

    static boolean isContinuous(int[] numbers) {
        // 思路1：排除0，记录大小王的数量。然后计算其他数字两两之间差额，有一样的不行。不一样的差额无法用大小王弥补也不行。
        if(numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);

        int zeroCount = 0;
        int diffCount = 0;
        int lastNumber = -1;
        for (int number : numbers) {
            if (number == 0) {
                zeroCount++;
            } else {
                if (lastNumber == -1) {
                    lastNumber = number;
                } else if (lastNumber == number) {
                    return false;
                } else {
                    diffCount += (number - lastNumber - 1);
                    lastNumber = number;
                }
            }
        }

        return zeroCount >= diffCount;
    }

}
