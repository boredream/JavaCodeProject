package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
public class Q98 {

    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.testSort()));
    }

    static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        Integer preValue = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            node = stack.pop();
            if (preValue != null && node.val <= preValue) return false;
            preValue = node.val;
            node = node.right;
        }
        return true;
    }
}
