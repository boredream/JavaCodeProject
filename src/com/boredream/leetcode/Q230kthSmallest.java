package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class Q230kthSmallest {
    public static void main(String[] args) {
        System.out.println(kthSmallest(TreeNode.testSort(), 3));
    }

    static int kthSmallest(TreeNode root, int k) {
        // 中序排列第k个
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return 0;
    }
}
