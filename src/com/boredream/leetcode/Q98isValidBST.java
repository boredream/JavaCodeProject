package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 *   2
 *  / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 *   5
 *  / \
 * 1   4
 *    / \
 *   3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Q98isValidBST {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.testSort();
        System.out.println(isValidBST(treeNode));
    }

//    static boolean isValidBST(TreeNode root) {
//        // FIXME 错，只判断当前结点的左右和自己比是不行滴
//        if(root != null) {
//            if(root.left != null) {
//                // 如果左结点为空，应该比当前小
//                if(root.val <= root.left.val) return false;
//            }
//            if(root.right != null) {
//                if(root.val >= root.right.val) return false;
//            }
//            // 左右结点都正常，递归下去
//            return isValidBST(root.left) && isValidBST(root.right);
//        }
//        return true;
//    }

    static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        Integer max = null;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(max != null && node.val <= max) return false;
            max = node.val;
            node = node.right;
        }
        return true;
    }


}
