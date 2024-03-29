package com.boredream.leetcode;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO 待优化
 */
public class Q134 {

    public static void main(String[] args) {
        // 需要整个开完，那就是剩余 > 消耗
        int[] gas = {6,0,1,3,2};
        int[] cost = {4,5,2,5,5};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        // 思路：双指针，start代表起点，end代表终点，
        int start = 0;
        int end = 0;
        int totalSurplus = 0;
        while(start < gas.length && end - start < gas.length) {
            if(totalSurplus < 0) {
                // 代表总的cost > gas，尝试滑动窗口start前进
                while(start < gas.length && start < end) {
                    int startSurplus = gas[start] - cost[start];
                    // 一直前进到总剩余非负
                    totalSurplus -= startSurplus;
                    start ++;
                    if (totalSurplus >= 0) {
                        break;
                    }
                }
            }
            int surplus = gas[end % gas.length] - cost[end % cost.length];
            totalSurplus += surplus;
            end ++;
        }
        return totalSurplus >= 0 && end - start >= gas.length ? start : -1;
        // TODO: chunyang 2023/7/17 优化空间，需要加强对逻辑的理解，当找到第一个totalSurplus < 0时，start可以直接提到end-1，没必要滑动窗口挨个找 
        // TODO: chunyang 2023/7/17 因为既然start到end都不可能，那start和end间的任意一点都不可能到end，因为 start 到 mid 点的剩余油量不可能是负数，不然就打不了mid
        // TODO: chunyang 2023/7/17 而start到mid如果是非负数，那mid到end的油量剩余就不可能大于start到end的剩余
    }
}
