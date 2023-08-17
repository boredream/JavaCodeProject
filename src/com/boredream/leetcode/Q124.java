package com.boredream.leetcode;


import com.boredream.entity.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Q124 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(-1);
        System.out.println(maxPathSum(node));
    }

    static int maxSum = Integer.MIN_VALUE;

    static int maxPathSum(TreeNode root) {
        // 思路：找到左右子节点下最大值的链，然后和当前值拼在一起。如果不如单边值，递归下去。
        maxListPathSum(root);
        return maxSum;
    }

    static int maxListPathSum(TreeNode root) {
        // 返回值是从当前节点开始向下，一个链能达到的最大值
        if (root == null) return 0;
        // TODO 这个max很关键，可以直接解决子节点如果是负数，则不累加它的问题
        int leftMaxSum = Math.max(maxListPathSum(root.left), 0);
        int rightMaxSum = Math.max(maxListPathSum(root.right), 0);
        // 以当前节点为根的可能最大值，可能是当前值，也可能是拼起来的链
        maxSum = Math.max(maxSum, root.val + leftMaxSum + rightMaxSum);
        // 返回最大可能的值，可能是当前值，也可能是链
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }

//    static int maxPathSum(TreeNode root) {
//        // 思路：递归+贪心？ 假设当前节点是路径的最根节点。那左节点的最大和+当前节点+右节点下的最大和，就是当前节点的最大值。
//        // 如果当前节点累加总和比某个子节点下累加更小，取子节点的。
//        // 子节点如此递归循环下去
//        if(root == null) return 0;
//        int leftSum = maxPathSum(root.left);
//        int rightSum = maxPathSum(root.right);
//        int sum = leftSum + root.val + rightSum;
//        if(sum > leftSum && sum > rightSum) return sum;
//        return Math.max(leftSum, rightSum);
//        // FIXME 思路错误，maxPathSum(root.left) 里已经是一个拐弯路径了，和当前节点无法连成路径
//    }

}
