package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.*;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class Q530 {

    public static void main(String[] args) {
        System.out.println(getMinimumDifference(TreeNode.testSort()));
    }

    static int getMinimumDifference(TreeNode root) {
        // 思路：二叉搜索树，DFS中序遍历，即升序，然后挨个计算差值，因为最小差值一定是相邻数字
        // 尝试迭代方式
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        int last = -1;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || node != null) {
            // 先一路递归到最左
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            // 出栈，即最左侧数字
            if(stack.size() > 0) {
                node = stack.pop();
                if (last != -1) min = Math.min(min, node.val - last);
                last = node.val;
                node = node.right;
            }
        }
        return min;
    }
}
