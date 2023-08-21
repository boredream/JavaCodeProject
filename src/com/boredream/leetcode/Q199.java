package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Q199 {

    public static void main(String[] args) {
        System.out.println(rightSideView(TreeNode.test()));
    }

//    static List<Integer> rightSideView(TreeNode root) {
//        // FIXME：错误，未考虑右侧孙节点都是空，但左节点的孙节点有值的情况
//        List<Integer> result = new ArrayList<>();
//        TreeNode node = root;
//        while(node != null) {
//            result.add(node.val);
//            if(node.right != null) {
//                node = node.right;
//            } else {
//                node = node.left;
//            }
//        }
//        return result;
//    }

    static List<Integer> rightSideView(TreeNode root) {
        // 思路：可以WFS，然后取最右节点。但是大部分层数，不需要处理左边的？感觉还是需要的。
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

}
