package com.boredream.leetcode;

public class ReshapeMatrix {

    public static void main(String[] args) {
        int[][] nums = {{1,2},
                        {3,4}};
        int[][] result = matrixReshape(nums, 1, 4);
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                System.out.print(result[i][i1] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 将二维数组组合成新数组
     * @param nums
     * @param r 新组数行数
     * @param c 新组数列数
     * @return 如果行列数不合法，返回原有数组，否则返回新结果数组
     */
    static int[][] matrixReshape(int[][] nums, int r, int c) {
        int numsRCount = nums.length, numsCCount = nums[0].length;
        if(numsRCount * numsCCount != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int curR = 0, curC = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = nums[curR][curC];
                curC ++;
                if(curC == numsCCount) {
                    curC = 0;
                    curR ++;
                }
            }
        }

        return result;
    }

}
