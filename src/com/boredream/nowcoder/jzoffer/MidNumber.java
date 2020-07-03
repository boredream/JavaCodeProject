package com.boredream.nowcoder.jzoffer;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MidNumber {

    public void Insert(Integer num) {

    }

    public Double GetMedian() {

        return 0d;
    }

    public static void main(String[] args) {
        // 思路1：中位数依赖于排序，而这种是动态插入的，所以先想到搜索二叉树的构建。
        // 但二叉树中位数不好找；那么不用搜索二叉树呢？又不好构建顺序数组

    }
}
