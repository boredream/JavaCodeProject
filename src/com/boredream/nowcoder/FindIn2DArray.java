package com.boredream.nowcoder;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindIn2DArray {

    public static void main(String[] args) {
        int[][] array = {
                {0, 2, 3, 4, 5, 6, 7},
                {1, 3, 5, 7, 9, 11, 13},
                {2, 4, 6, 8, 10, 12, 14},
        };
        System.out.println(find(11, array));
    }

    static boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        if (array[0][0] > target || array[array.length - 1][array[0].length - 1] < target) return false;

        int height = array.length;
        int width = array[0].length;
        int x = height-1, y = 0;

        /* 思路
        * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
        * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
        * 要查找数字比左下角数字小时，上移 */
        for(int step=0;x>=0&&y<width;step++) {
            System.out.println("------- step = " + step + " ... [" + x + "," + y + "]");
            if(target == array[x][y]) {
                System.out.println("get num " + target + " in [" + x + "," + y + "]");
                return true;
            } else if(target > array[x][y]) {
                y++;
            } else if(target < array[x][y]) {
                x--;
            }
        }

        return false;
    }

}
