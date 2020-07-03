package com.boredream.entity;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode test() {
        //       8
        //    /    \
        //   6      10
        //  / \     / \
        // 5   7   9  11
        TreeNode root = new TreeNode();
        root.val = 8;
        root.left = new TreeNode();
        root.left.val = 6;
        root.left.left = new TreeNode();
        root.left.left.val = 5;
        root.left.right = new TreeNode();
        root.left.right.val = 7;
        root.right = new TreeNode();
        root.right.val = 10;
        root.right.left = new TreeNode();
        root.right.left.val = 9;
        root.right.right = new TreeNode();
        root.right.right.val = 11;
        return root;
    }

    public static TreeNode testSort() {
        //       4
        //     /   \
        //    2     6
        //  / \     / \
        // 1   3   5   7
        TreeNode root = new TreeNode();
        root.val = 4;
        root.left = new TreeNode();
        root.left.val = 2;
        root.left.left = new TreeNode();
        root.left.left.val = 1;
        root.left.right = new TreeNode();
        root.left.right.val = 3;
        root.right = new TreeNode();
        root.right.val = 6;
        root.right.left = new TreeNode();
        root.right.left.val = 5;
        root.right.right = new TreeNode();
        root.right.right.val = 7;
        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                sb.append(head.val).append(" ");

                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // test
        TreeNode node = TreeNode.test();
        System.out.println(node);
    }
}