package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * TODO 递归不一定要一路return 回去，也可以考虑全局变量保存
 */
public class Q236 {

    private static TreeNode ans;

    public static void main(String[] args) {
        TreeNode node = TreeNode.test();
        System.out.println(lowestCommonAncestor(node, node.left.left, node.left.right));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 思路：递归思路。如果当前节点是祖先，则 当前节点+左+右，一定会包含p和q
        // 一层层递归下去，只要符合条件的就保存全局变量，递归结束则变量为最底层的可能性答案
        hasDescendants(root, p, q);
        return ans;
    }

    static boolean hasDescendants(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean leftHas = hasDescendants(root.left, p, q);
        boolean rightHas = hasDescendants(root.right, p, q);
        if ((leftHas && rightHas) || ((root.val == p.val || root.val == q.val) && (leftHas || rightHas))) {
            ans = root;
        }
        return leftHas || rightHas || root.val == p.val || root.val == q.val;
    }

}
