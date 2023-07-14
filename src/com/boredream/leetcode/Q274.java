package com.boredream.leetcode;

import com.boredream.leetcode.util.Method;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 * <p>
 * 输入：citations = [1,3,1]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/h-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q274 {

    public static void main(String[] args) {
        // 最大的N个N数字
        int[] nums = {1,3,1};
        System.out.println(hIndex(nums));
    }

    static int hIndex(int[] citations) {
        // 思路：首先n最大只能是length-1，必须要数量&数字都最大
        // 排序，然后大到小，遍历到count>数字时，结束
        int h = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] <= h) {
                break;
            }
            h = citations.length - i;
        }
        return h;
    }

    // TODO: chunyang 2023/7/14 排序是nLogn，可以用计数算法优化到时间on

}
