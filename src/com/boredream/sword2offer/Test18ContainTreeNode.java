package com.boredream.sword2offer;

import com.boredream.entity.TreeNode;

public class Test18ContainTreeNode {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     *
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     * @return true：树B是树A的子结构，false：树B是不树A的子结构
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root2 == null) return true;
        if (root1 == null) return false;

        boolean result = false;
        if (root1.val == root2.val) {
            // 根节点相通，接着对比
            result = match(root1, root2);
        }

        if (result) return true;

        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private static boolean match(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root2 == null) return true;
        if (root1 == null) return false;
        return root1.val == root2.val && match(root1.left, root2.left) && match(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        root1.val = 8;
        root1.right = new TreeNode();
        root1.right.val = 7;
        root1.left = new TreeNode();
        root1.left.val = 8;
        root1.left.left = new TreeNode();
        root1.left.left.val = 9;
        root1.left.right = new TreeNode();
        root1.left.right.val = 2;
        root1.left.right.left = new TreeNode();
        root1.left.right.left.left = new TreeNode();
        root1.left.right.left.left.val = 4;
        root1.left.right.left.right = new TreeNode();
        root1.left.right.left.right.val = 7;
        TreeNode root2 = new TreeNode();
        root2.val = 8;
        root2.left = new TreeNode();
        root2.left.val = 9;
        root2.right = new TreeNode();
        root2.right.val = 2;
        System.out.println(hasSubtree(root1, root2));
        System.out.println(hasSubtree(root2, root1));
        System.out.println(hasSubtree(root1, root1.left));
        System.out.println(hasSubtree(root1, null));
        System.out.println(hasSubtree(null, root2));
        System.out.println(hasSubtree(null, null));
    }

}
