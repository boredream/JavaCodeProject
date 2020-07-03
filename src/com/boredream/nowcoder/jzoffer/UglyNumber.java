package com.boredream.nowcoder.jzoffer;

import java.util.ArrayList;

/**
 * 只包含2 3 5质数因子的叫丑数，14不是，因为=2*7包含7
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }

    static int GetUglyNumber_Solution(int index) {
        // 思路1：网上的。235不停累乘，到数量index后结束。
        // 用仨指针指向上一个乘235不同的结果，每次都拿出来继续乘235，并记录仨结果里最小的一个，并刷新对应指针位置
        if (index < 7) return index;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (list.size() < index) {
            Integer i2total = list.get(i2) * 2;
            Integer i3total = list.get(i3) * 3;
            Integer i5total = list.get(i5) * 5;
            int min = Math.min(i2total, Math.min(i3total, i5total));
            list.add(min);
            if (min == i2total) i2++;
            if (min == i3total) i3++;
            if (min == i5total) i5++;

        }
        return list.get(list.size() - 1);
    }

}
