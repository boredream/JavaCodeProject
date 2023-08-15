package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class Q105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
        System.out.println(buildTree1(preorder, inorder));
    }

    static TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 思路：前序是 中左右；中序是 左中右
        // 迭代构建是 DFS，按前序的中左右顺序
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> leftNodeStack = new Stack<>();
        leftNodeStack.add(root);
        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = leftNodeStack.peek();
            // 如果前序的数字和中序的不同，代表一直是左节点，加入栈
            if(node.val != inorder[inIndex]) {
                node.left = new TreeNode(preorder[i]);
                leftNodeStack.add(node.left);
            } else {
                // 如果前序数字和中序相同，代表到达最左了，则回退栈找到应该添加右节点的位置
                while(!leftNodeStack.isEmpty() && leftNodeStack.peek().val == inorder[inIndex]) {
                    node = leftNodeStack.pop();
                    inIndex ++;
                }
                node.right = new TreeNode(preorder[i]);
                leftNodeStack.push(node.right);
            }
        }
        return root;
    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 思路：前序是 中左右；中序是 左中右
        // 递归构建一般是 WFS，先前序找到根节点，然后拿根节点去中序里确定左右的树，循环递归

        HashMap<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numIndexMap.put(inorder[i], i);
        }

        return buildTree(numIndexMap, preorder,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private static TreeNode buildTree(HashMap<Integer, Integer> numIndexMap,
                                      int[] preorder, int preStart, int preEnd,
                                      int inStart, int inEnd) {
        // preorder 的 start 是根节点
        if(preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 找到根节点在中序里的位置
        Integer inorderRootSplit = numIndexMap.get(rootVal);
        // 中序里根节点分割左右节点
        int leftInStart = inStart;
        int leftInEnd = inorderRootSplit - 1;
        int rightInStart = inorderRootSplit + 1;
        int rightInEnd = inEnd;
        // 前序按照 start + 1 ~ 左节点数量，~ 结束分割
        int leftCount = leftInEnd - leftInStart + 1;
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftCount - 1;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;

        root.left = buildTree(numIndexMap, preorder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
        root.right = buildTree(numIndexMap, preorder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
        return root;
    }

}
