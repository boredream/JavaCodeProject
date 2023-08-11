package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Q101isSymmetric {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(2);
        System.out.println(isSymmetric2(node));
    }

    static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        // 镜像就是我 left.left = right.right && left.right = right.left
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.val == root2.val &&
                isSymmetric(root1.left, root2.right) &&
                isSymmetric(root1.right, root2.left);
    }

    static boolean isSymmetric1(TreeNode root) {
        // 思路：先定义镜像的判断标准，即根节点的左节点是和右节点是翻转对应的
        // 如何判断俩翻转对应呢？ 当前val相等，且left.left对应right.right && left.right对应right.left

        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        // 非递归方式判断，一个队列，一个左一个右轮着加入
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size % 2 == 1) {
                // 奇数，一定是不对称的
                return false;
            }

            // 应该每次头尾各取一个，然后对应翻转
            LinkedList<TreeNode> list = new LinkedList<>();
            for (int i = 0; i < size / 2; i++) {
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeLast();
                if (left == null && right == null) return true;
                if (left == null || right == null) return false;
                if(left.val != right.val) return false;

                list.addFirst(left.right);
                list.addFirst(left.left);
                list.addLast(right.left);
                list.addLast(right.right);
            }
            queue.addAll(list);
        }
        return true;
    }

    static boolean isSymmetric2(TreeNode root) {
        if (root == null) return false;
        return isSymmetric2(root.left, root.right);
    }

    private static boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
    }

}
