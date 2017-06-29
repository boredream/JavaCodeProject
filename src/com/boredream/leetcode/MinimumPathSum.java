package com.boredream.leetcode;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        System.out.println(minPathSum(grid));
    }

    static int minPathSum(int[][] grid) {
        // TODO: 2017/6/29 网上的算法
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }






    // 只考虑到下一步，应该穷举

//    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},
//                        {1,5,1},
//                        {4,2,1}};
//        System.out.println(minPathSum(grid));
//    }
//
//    static int totalSum = 0;
//
//    static int minPathSum(int[][] grid) {
//        if(grid.length == 0) return 0;
//        stepPath(0, 0, 0, grid);
//        return totalSum;
//    }
//
//    static void stepPath(int x, int y, int sum, int[][] grid) {
//        sum += grid[y][x];
//
//        while(true) {
//            if(x == grid[0].length-1 && y == grid.length - 1) {
//                break;
//            }
//
//            if(x == grid[y].length-1) {
//                // 最右端，只能朝下
//                sum += grid[y+1][x];
//                y ++;
//            } else if(y == grid.length-1){
//                // 最低端，只能朝右
//                sum += grid[y][x+1];
//                x ++;
//            } else {
//                int right = grid[y][x+1];
//                int bottom = grid[y+1][x];
//                if(right < bottom) {
//                    x ++;
//                    sum += right;
//                } else if(bottom < right) {
//                    y ++;
//                    sum += bottom;
//                } else {
//                    // 右和下相等，分开两条路走
//                    if(x == grid[y].length - 2) {
//                        // 右边的是最边上了，朝下走
//                        y ++;
//                        sum += bottom;
//                    } else if(y == grid.length - 2) {
//                        // 下边的是最边上了，朝右走
//                        x ++;
//                        sum += right;
//                    } else {
//                        stepPath(x+1, y, sum, grid);
//                        stepPath(x, y+1, sum, grid);
//                        return;
//                    }
//                }
//            }
//        }
//
//        if(totalSum == 0 || sum < totalSum) {
//            totalSum = sum;
//        }
//    }
}
