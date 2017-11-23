package com.boredream.nowcoder;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class TreeIsSymmetrical {

    public static void main(String[] args) {
        TreeNode node = TreeNode.test();
        System.out.println(isSymmetrical(node));

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(3);
        node2.right = new TreeNode(3);

    }

    /*
     *  思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     *  左子树的右子树和右子树的左子树相同即可，采用递归
     *  非递归也可，采用栈或队列存取各级子树根节点
     */
    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return recIsSym(pRoot.left, pRoot.right);
    }

    static boolean recIsSym(TreeNode left, TreeNode right) {
        if(left == null) return right == null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return recIsSym(left.left, left.right) && recIsSym(right.left, right.right);
    }

}
