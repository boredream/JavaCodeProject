package com.boredream.leetcode;


import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 */
public class Q112 {

    public static void main(String[] args) {
        TreeNode node = TreeNode.test();
        System.out.println(hasPathSum(node, 12));
    }

    static boolean hasPathSum(TreeNode root, int targetSum) {
        // 思路：DFS挨个找，省空间O1
        // 递归，把当前的值，一层层的传递到叶节点，只要有一个满足要求，即可
        // 如果递归到空节点，且targetSum正好清零了，代表上个节点正好满足，返回true
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

}
