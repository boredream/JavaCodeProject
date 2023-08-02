package com.boredream.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * TODO 参考了官方写法
 */
public class Q128 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 1;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            // 没有比当前数字更小的了，代表是起点数字。则尝试不停的+1
            int max = num;
            while (set.contains(max)) {
                max++;
            }
            maxLength = Math.max(maxLength, max - num);
        }
        return maxLength;
    }

//    static int longestConsecutive(int[] nums) {
//        // 思路：On，如何判断连续数字呢？每次判断+1-1？
//        // 数字不连续也可以，所以要维护多组
//        // 对于每个数字，都保存在map里，key是数字，value是最大数。当有新数字来的时候+1-1判断是否和他连着，是的话，取他的value然后+1保存到新数字
//
//        // 方案不对。新数字如果在连续数字的左边，加入map后变成n。之后来了个新数字在右侧 n+1。之后又来个左侧数字，如果基于左侧n就错误了。
//        // 所以需要新数字，一要判断出是否已有连续数字，二是判断已有连续数字的连续数量
//        return 0;
//    }

//    static int longestConsecutive(int[] nums) {
//        // 思路：基于上述思路。对新数字，一要判断出是否已有连续数字，二是判断已有连续数字的连续数量
//        // 可以map中保存连续数字的最大最小值，且保存 最小-最大 最大-最小 都保存进map。
//        // 注意处理新数字插入后，把两组连续数字连到一起的情况
//        int maxLength = 1;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            int small = num - 1;
//            if(map.containsKey(small)) {
//                // 如果map里有比当前数字正好-1的
//                int smallValue = map.get(small);
//                // 数字的另一端如果比当前数字更小，则代表左侧数字是连续数字的最大值，则当前数字直接替换之
//                if(smallValue < num) {
//                    map.remove(small);
//                    map.put(smallValue, num);
//                    map.put(num, smallValue);
//                    maxLength = Math.max(maxLength, num - smallValue + 1);
//                }
//                // 数字的另一端如果比当前数字更大，则当前数字已经被包含了，略过
//            }
//
//            int big = num + 1;
//            if(map.containsKey(big)) {
//                int bigValue = map.get(big);
//                if(bigValue > num) {
//                    map.remove(big);
//                    map.put(bigValue, num);
//                    map.put(num, bigValue);
//                    maxLength = Math.max(maxLength, bigValue - num + 1);
//                }
//            }
//
//            map.put(num, num);
//        }
//        // FIXME: 2023/8/2 太复杂，算法不适合
//        return maxLength;
//    }

}
