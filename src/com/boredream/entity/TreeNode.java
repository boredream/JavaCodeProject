package com.boredream.entity;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode test() {
        TreeNode node = new TreeNode(6);

        TreeNode left = new TreeNode(3);
        left.right = new TreeNode(2);
        node.left = left;

        TreeNode right2 = new TreeNode(4);
        right2.left = new TreeNode(10);
        right2.right = new TreeNode(15);

        TreeNode right = new TreeNode(8);
        right.right = right2;
        node.right = right;

        return node;
    }

}