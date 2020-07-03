package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintTreeFromTopToBottom {

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6      10
        //  / \     / \
        // 5   7   9  11
        System.out.println(PrintFromTopToBottom(TreeNode.test()));
    }

    private static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        // 思路1：BFS广度优先搜索，不用递归
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode next = queue.poll();
            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
            result.add(next.val);
        }
        return result;
    }

}
