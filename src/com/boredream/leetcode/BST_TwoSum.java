package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.HashSet;

/**
 * 题目：寻找二叉树有没有一个节点是两个分支综合为目标k的，有就返回true
 */
public class BST_TwoSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean target = findTarget(root, 3);
        System.out.println(target);
    }

    /**
     * 思路：挨个遍历二叉树~判断和
     * 答案：这次没有再使用其他方法，直接用了带return值的方法自己去做递归
     * 妈个鸡又是错误，应该是任意两个元素就行，不用某个分支下面直属俩元素
     */
//    static boolean findTarget(TreeNode root, int k) {
//        if(root == null) return false;
//        if(root.left != null && root.right != null && root.left.val + root.right.val == k) return true;
//        return findTarget(root.left, k) || findTarget(root.right, k);
//    }

    static boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> firstSet = new HashSet<>();
        return findSecond(firstSet, root, k);
    }

    static boolean findSecond(HashSet<Integer> firstSet, TreeNode root, int k) {
        if(root == null) return false;
        if(firstSet.contains(k - root.val)) return true; // 精华~
        firstSet.add(root.val);
        return findSecond(firstSet, root.left, k) || findSecond(firstSet, root.right, k);
    }


}
