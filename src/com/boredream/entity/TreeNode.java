package com.boredream.entity;

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