package com.boredream.leetcode;

import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q454 {

    public static void main(String[] args) {
        System.out.println(fourSumCount(
                new int[]{-1, -1},
                new int[]{-1, 1},
                new int[]{-1, 1},
                new int[]{1, -1}
        ));
    }

    static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        // 暴力法：4重for循环
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    for (int d : D) {
                        if (a + b + c + d == 0) count++;
                    }
                }
            }
        }
        return count;
    }

    static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // A + B 交叉，结果里相同的应该都去重，之后再和后续交叉同理，注意相同结果的数量累加
        HashMap<Integer, Integer> ab = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                ab.put(sum, ab.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (ab.containsKey(-sum)) {
                    count += ab.get(-sum);
                }
            }
        }

        return count;
    }

}
