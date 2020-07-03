package com.boredream.nowcoder.jzoffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(RectCover1(i));
        }
    }

    private static int RectCover1(int target) {
        // 思路1：还~是动态规划问题。当最后剩1*2时，只有一种摆法。当最后剩2*2时，有两种摆法。
        // 但有一种是重复的，所以还是 fn = fn-1 + fn-2
        if (target == 0) return 0;
        if (target <= 2) return target;

        int n2 = 1;
        int n1 = 2;
        int total = 0;
        for (int i = 3; i <= target; i++) {
            total = n2 + n1;
            n2 = n1;
            n1 = total;
        }
        return total;
    }

}
