package com.boredream.AlgBase;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历
 */
public class foreachTreeNode {

    public static void main(String[] args) {
        TreeNode node = TreeNode.test();
        foreach1(node);
        System.out.println();
        foreach2(node);
    }

    /**
     * 方式1，递归。顺序是从左到右一条分支走到底，然后换另一条分支
     */
    private static void foreach1(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        foreach1(root.left);
        foreach1(root.right);
    }

    /**
     * 方式2，集合临时保存每一层。
     * 顺序是每层从右到左（后进先出）
     */
    private static void foreach2(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            System.out.print(node.val + " ");

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }
    }

}
