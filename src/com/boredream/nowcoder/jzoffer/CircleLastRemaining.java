package com.boredream.nowcoder.jzoffer;

/**
 * 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友出圈,从他的下一个小朋友开始,继续0...m-1报数....
 * 这样下去....直到剩下最后一个小朋友，请问是哪个留到最后 (注：小朋友的编号是从0到n-1)
 */
public class CircleLastRemaining {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(10, 3));
    }

    static int LastRemaining_Solution(int n, int m) {
        // 思路1：while循环，然后注意 % 的计算，每次step m。
        // 但是 n 又不能 --，因为最后要找到小朋友编号。所以使用数组先保留所有数字，每次删除的置为-1
        if (n < 1 || m < 1) return -1;
        int[] array = new int[n];
        int index = -1;
        int stepCount = 0;
        int removeCount = 0;
        while (n > removeCount) {
            // 每次前进1，遇到-1跳过不算
            index ++;
            if(index >= n) index = 0;
            if (array[index] == -1) continue;

            stepCount++;
            if(stepCount == m) {
                // 当前进了m步时，移除当前位置小朋友。重新计数
                array[index] = -1;
                removeCount++;
                stepCount = 0;
            }
        }
        return index;
    }

}
