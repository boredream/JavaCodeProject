package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class Q230 {

    public static void main(String[] args) {
        System.out.println(kthSmallest(TreeNode.testSort(), 3));
    }

    static int kthSmallest(TreeNode root, int k) {
        // 思路：中序遍历的第k个
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            if(!stack.isEmpty()) {
                node = stack.pop();
                if(--k == 0) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return -1;
    }
}
