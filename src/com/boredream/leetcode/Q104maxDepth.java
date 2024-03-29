package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * 返回它的最大深度 3 。
 */
public class Q104maxDepth {

    public static void main(String[] args) {
        System.out.println(maxDepth1(TreeNode.test()));
    }

    static int maxDepth(TreeNode root) {
        // 最大深度~ DFS和BFS应该都可以~ 先来BFS版本
        int deep = 0;
        if (root == null) return deep;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            deep++;
        }
        return deep;
    }

    static int maxDepthDFS(TreeNode root) { // dfs递归版
        return root == null ? 0 : Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)) + 1;
    }

    static int maxDepth1(TreeNode root) {
        // 思路：最大深度，必须遍历到所有节点，DFS or WFS
        // DFS可以递归，也可以栈？不可以
        // WFS可以递归，或队列
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return depth;
    }
}
