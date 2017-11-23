package com.boredream.nowcoder;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Rect2nCover {

    public static void main(String[] args) {
        // 核心是分析规律
        // 2*1的时候一种，2*2的时候2种
        // 2*n的时候，最左侧第一个分竖着摆和横着摆两种，然后剩下宽度就只有n-1和n-2
        // 所以 f(2) = f(n-1) + f(n-2) 然后得出为斐波那契数列
        System.out.println(RectCover(6));
    }

    static int RectCover(int target) {
        if(target <= 0) return 0;
        if(target <= 2) return target;

        int r1 = 1;
        int r2 = 2;
        int total = 2;
        for (int i = 3; i <= target; i++) {
            total = r1 + r2;
            r1 = r2;
            r2 = total;
        }

        return total;
    }
}
