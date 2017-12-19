package com.boredream.AlgBase;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 */
public class foreachTreeNode {

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6      10
        //  / \     / \
        // 5   7   9  11
        TreeNode node = TreeNode.test();
        foreach1(node);
        System.out.println();
        foreach2(node);
        System.out.println();
        foreach3(node);

        System.out.println();
        System.out.println();

        foreach10(node);

        System.out.println();
        System.out.println();

        foreach11(node);
        System.out.println();
        foreach12(node);
        System.out.println();
        foreach13(node);


    }

    /**
     * 递归。
     * 前序遍历
     */
    private static void foreach1(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        foreach1(root.left);
        foreach1(root.right);
    }

    /**
     * 递归。
     * 中序遍历
     */
    private static void foreach2(TreeNode root) {
        if(root == null) return;
        foreach2(root.left);
        System.out.print(root.val + " ");
        foreach2(root.right);
    }

    /**
     * 递归。
     * 后序遍历
     */
    private static void foreach3(TreeNode root) {
        if(root == null) return;
        foreach3(root.left);
        foreach3(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 集合临时保存每一层。
     * 一层一层从左到右遍历
     */
    private static void foreach10(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            System.out.print(node.val + " ");
            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }
    }

    /**
     * 集合临时保存每一层。
     * 前序遍历
     */
    private static void foreach11(TreeNode root) {
        if(root == null) return;
        // 栈，先进后出
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            System.out.print(node.val + " ");
            // 栈后进先出，所以left在后
            if(node.right != null) nodes.add(node.right);
            if(node.left != null) nodes.add(node.left);
        }
    }

    /**
     * 集合临时保存每一层。
     * 中序遍历
     */
    private static void foreach12(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /**
     * 集合临时保存每一层。
     * 后序遍历
     */
    private static void foreach13(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                TreeNode temp = stack.peek().right;
                if (temp == null || temp == prev) {
                    node = stack.pop();
                    System.out.print(node.val + " ");
                    prev = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }

}
