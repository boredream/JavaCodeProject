package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsMirrorTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        tree.left = left;

        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        tree.right = right;

        System.out.println(isSymmetrical(tree));
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        // 思路1：等价于 左右俩子树完全相等。
        if (pRoot == null) return true;
        return isEqualTree(pRoot.left, pRoot.right);
    }

    private static boolean isEqualTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isEqualTree(left.left, right.right) && isEqualTree(left.right, right.left);
    }

}
