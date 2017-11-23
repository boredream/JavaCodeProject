package com.boredream.nowcoder;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorBinaryTree {

    public static void main(String[] args) {
        TreeNode test = TreeNode.test();
        Mirror2(test);
        System.out.println(test);
    }

    /**
     * 常规迭代做法
     */
    static void Mirror(TreeNode root) {
        if(root == null) return;
        Mirror(root.left);
        Mirror(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    /**
     * 非迭代做法
     */
    static void Mirror2(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }
    }


}
