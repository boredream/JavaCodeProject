package com.boredream.nowcoder.jzoffer;

/**
 * 二维数组查找
 * <p>在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoDArrayFind {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {2, 3, 5, 7, 8},
                {4, 5, 7, 8, 9},
        };
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " ： " + Find3(i, array));
        }
    }

    private static boolean Find1(int target, int[][] array) {
        // 思路1：x横轴、y纵轴，先横线挨个判断，如果到底or下一个比target大，则向下找。  PASS 方案不行
        return false;
    }

    private static boolean Find2(int target, int[][] array) {
        // 思路2：左上起点，每次右+下两个分支，类似于二叉树查找。使用dfs查找。但是会有重复的情况？   PASS 时间复杂度太高
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        return dfs(target, array, 0, 0);
    }

    private static boolean dfs(int target, int[][] array, int x, int y) {
        // 如果找到 return true
        if (array[y][x] == target) return true;

        // 没找到，继续向下向右
        // 如果到右下角了，结束
        if (x == array.length - 1 && y == array[0].length) {
            return false;
        }

        // 如果没到边界，才可能继续坐标+1
        if (x < array.length - 1 && dfs(target, array, x + 1, y)) {
            // 向右找到了
            return true;
        }

        if (y < array[0].length - 1 && dfs(target, array, x, y + 1)) {
            // 向下找到了
            return true;
        }

        return false;
    }

    private static boolean Find3(int target, int[][] array) {
        // 思路3：左下角算起，向上- 向右+，因此判断target 看是向右还是向上走
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int x = 0;
        int y = array.length - 1;

        while (x < array[0].length && y >= 0) {
            if (array[y][x] < target) {
                // 向右
                x++;
            } else if (array[y][x] > target) {
                y--;
            } else {
                return true;
            }
        }

        return false;
    }


}
