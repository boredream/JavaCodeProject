package com.boredream.nowcoder;

/**
 * 圆排列0~n个小朋友，给1个数字m，小朋友们轮流报数，每次到m-1的小朋友抬走下一个，继续
 * 问最后的小朋友是谁
 */
public class LastRemainingSolution {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 1));
    }

    static int LastRemaining_Solution(int n, int m) {
        int index = -1;
        int target = 0;
        int count = n;
        int[] array = new int[n];
        while(count > 0) {
            index ++;
            if(index == n) index = 0;
            if(array[index] == -1) continue;

            target ++;
            if(target == m) {
                array[index] = -1;
                target = 0;
                count --;
            }
        }

        return index;
    }


}
