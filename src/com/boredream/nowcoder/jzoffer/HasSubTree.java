package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

/**
 * 是否包含子树，判断2是否是1的子树
 */
public class HasSubTree {

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.test();
        TreeNode root2 = new TreeNode();
        root2.val = 6;
        root2.left = new TreeNode();
        root2.left.val = 5;
        root2.right = new TreeNode();
        root2.right.val = 7;

        System.out.println(HasSubtree1(root1, root2));
    }

    private static boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        // 思路1：从上到下挨个遍历，当起始结点相等时，向下遍历
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val && EqualTree(root1, root2)) return true; // 如果相等，继续向下挨个判断相等
        else return HasSubtree1(root1.left, root2) || HasSubtree1(root1.right, root2); // 不相等，or子不相等，继续用下面的子节点
    }

    private static boolean EqualTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true; // 如果Tree2已经遍历完了都能对应的上，返回true
        if (root1 == null) return false; // 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        return root1.val == root2.val && EqualTree(root1.left, root2.left) && EqualTree(root1.right, root2.right);
    }

}
