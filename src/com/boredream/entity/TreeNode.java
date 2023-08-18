package com.boredream.entity;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode generateByArray(Integer[] array) {
        if (array.length == 0) return null;
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> levelTreeNode = new LinkedList<>();
        levelTreeNode.add(root);

        int index = 1;
        while (index < array.length) {
            int size = levelTreeNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelTreeNode.poll();
                if (node != null) {
                    node.left = array[index] == null ? null : new TreeNode(array[index]);
                    levelTreeNode.add(node.left);

                    node.right = array[index + 1] == null ? null : new TreeNode(array[index + 1]);
                    levelTreeNode.add(node.right);
                }
                index += 2;
            }
        }
        return root;
    }

    public static TreeNode test() {
        //       8
        //     /   \
        //    6     2
        //   / \    / \
        //  5   7  3   1
        TreeNode root = new TreeNode();
        root.val = 8;
        root.left = new TreeNode();
        root.left.val = 6;
        root.left.left = new TreeNode();
        root.left.left.val = 5;
        root.left.right = new TreeNode();
        root.left.right.val = 7;
        root.right = new TreeNode();
        root.right.val = 2;
        root.right.left = new TreeNode();
        root.right.left.val = 3;
        root.right.right = new TreeNode();
        root.right.right.val = 1;
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
                if (head == null) {
                    sb.append("null ");
                    continue;
                }
                sb.append(head.val).append(" ");

                queue.offer(head.left);
                queue.offer(head.right);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // test
        TreeNode node = TreeNode.generateByArray(new Integer[]{7, 3, 15, null, null, 9, 20});
        System.out.println(node);
    }
}