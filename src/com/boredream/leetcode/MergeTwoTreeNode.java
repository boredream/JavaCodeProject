package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

public class MergeTwoTreeNode {

    public static void main(String[] args) {
        TreeNode node1L = new TreeNode(3);
        node1L.left = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node1.left = node1L;
        node1.right = new TreeNode(2);

        TreeNode node2L = new TreeNode(1);
        node2L.right = new TreeNode(4);
        TreeNode node2R = new TreeNode(3);
        node2R.right = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        node2.left = node2L;
        node2.right = node2R;

        TreeNode treeNode = mergeTrees(node1, node2);
        System.out.println(treeNode);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        TreeNode node = new TreeNode(0);
        recMergeTrees(node, t1, t2);
        return node;
    }

    private static void recMergeTrees(TreeNode root, TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return;
        }

        if(t1 != null && t2 != null) {
            root.val = t1.val + t2.val;
            if(t1.left != null || t2.left != null) {
                root.left = new TreeNode(0);
                recMergeTrees(root.left, t1.left, t2.left);
            }
            if(t1.right != null || t2.right != null) {
                root.right = new TreeNode(0);
                recMergeTrees(root.right, t1.right, t2.right);
            }
        } else if(t1 != null) {
            root.val = t1.val;
            if(t1.left != null) {
                root.left = new TreeNode(0);
                recMergeTrees(root.left, t1.left, null);
            }
            if(t1.right != null) {
                root.right = new TreeNode(0);
                recMergeTrees(root.right, t1.right, null);
            }
        } else {
            root.val = t2.val;
            if(t2.left != null) {
                root.left = new TreeNode(0);
                recMergeTrees(root.left, null, t2.left);
            }
            if(t2.right != null) {
                root.right = new TreeNode(0);
                recMergeTrees(root.right, null, t2.right);
            }
        }
    }
}
