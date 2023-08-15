package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *      3
 *   9     20
 *       15   7
 */
public class Q106 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(buildTree(inorder, postorder));
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 思路：递归的WFS更好理解，类似前序+中序逻辑
        HashMap<Integer, Integer> inorderNumIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderNumIndexMap.put(inorder[i], i);
        }
        return buildTree(inorderNumIndexMap, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    static TreeNode buildTree(HashMap<Integer, Integer> inorderNumIndexMap, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if(postStart > postEnd) {
            return null;
        }

        // 后续的最后一位是根节点
        int rootValue = postorder[postEnd];
        TreeNode node = new TreeNode(rootValue);

        // 中序是左中右，以根节点为界，左边是left，右边是right
        int rootSplitIndex = inorderNumIndexMap.get(rootValue);
        int leftInStart = inStart;
        int leftInEnd = rootSplitIndex - 1;
        int rightInStart = rootSplitIndex + 1;
        int rightInEnd = inEnd;

        // 后序是左右中
        int leftPostStart = postStart;
        int leftPostEnd = postStart + (leftInEnd - leftInStart);
        int rightPostStart = leftPostEnd + 1;
        int rightPostEnd = postEnd - 1;

        node.left = buildTree(inorderNumIndexMap, leftInStart, leftInEnd, postorder, leftPostStart, leftPostEnd);
        node.right = buildTree(inorderNumIndexMap, rightInStart, rightInEnd, postorder, rightPostStart, rightPostEnd);
        return node;
    }

}
