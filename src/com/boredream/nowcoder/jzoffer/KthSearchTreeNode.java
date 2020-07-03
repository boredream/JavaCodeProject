package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthSearchTreeNode {

    public static void main(String[] args) {
        TreeNode test = TreeNode.testSort();
        System.out.println(KthNode1(test, 2));

    }

    static TreeNode KthNode1(TreeNode root, int k) {
        // 思路1：搜索二叉树的中序遍历就是排序输出
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        int index = 0;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                if (++index == k) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }

}
