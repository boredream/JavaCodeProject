package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * https://leetcode.cn/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class Q226 {

    public static void main(String[] args) {
        System.out.println(invertTree(TreeNode.test()));
    }

    static TreeNode invertTree(TreeNode root) {
        // 思路：整体树镜像，所以要节点左右替换，而不只是值替换。尽量原树上交换。WFS
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode poll = queue.poll();

                TreeNode temp = poll.left;
                poll.left = poll.right;
                poll.right = temp;

                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }

}
