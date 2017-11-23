package com.boredream.entity;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     *         6
     *    3        8
     * -    2   -     4
     *              10 15
     */
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

    @Override
    public String toString() {
        // FIXME: 2017/11/23 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < print(this).size(); i++) {
            System.out.print(print(this).get(i) + " ");
        }
        return sb.toString();
    }

    public ArrayList<String> print(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        result.add(root.val + "");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();

                if (head.left != null) {
                    queue.offer(head.left);
                    result.add(head.left.val + "");
                } else {
                    result.add("X");
                }

                if (head.right != null) {
                    queue.offer(head.right);
                    result.add(head.right.val + "");
                } else {
                    result.add("X");
                }
            }
        }
        return result;
    }
}