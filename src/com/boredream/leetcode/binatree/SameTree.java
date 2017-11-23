package com.boredream.leetcode.binatree;

import com.boredream.entity.TreeNode;

/**
 * 比较俩二叉树相等
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode test = TreeNode.test();
        System.out.println(isSameTree(test, test.left));
    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 一次通过~带返回值的递归oh yeah！
     */
}
