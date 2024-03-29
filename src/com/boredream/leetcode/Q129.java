package com.boredream.leetcode;


import com.boredream.entity.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 */
public class Q129 {

    public static void main(String[] args) {
        TreeNode node = TreeNode.test();
        System.out.println(sumNumbers(node));
    }

    static int totalSum;

    static int sumNumbers(TreeNode root) {
        // 思路：WFS 记录现有数字，每加一层就累加数字。可以用递归记住当前累加数字，如果是迭代需要额外空间。
        sumNumbers(0, root);
        return totalSum;
    }

    private static void sumNumbers(int sum, TreeNode root) {
        if(root == null) {
            return;
        }
        // 当前有节点，已有sum * 10 + 当前值
        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null) {
            totalSum += sum;
            return;
        }
        sumNumbers(sum, root.left);
        sumNumbers(sum, root.right);
    }

}
