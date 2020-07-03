package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

/**
 * 二叉树镜像
 */
public class MirrorTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.test();
        mirror(tree);
        System.out.println(tree);
    }

    private static void mirror(TreeNode root) {
        // 思路1：dfs + 交换左右
        if(root == null) return;
        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
