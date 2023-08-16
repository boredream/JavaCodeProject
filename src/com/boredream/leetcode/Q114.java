package com.boredream.leetcode;


import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 *
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 *
 * TODO 参考官方思路
 */
public class Q114 {

    public static void main(String[] args) {
        TreeNode node = TreeNode.test();
        flatten(node);
        System.out.println(node);
    }

    static void flatten(TreeNode root) {
        // 思路：从根节点开始，先找到左节点展开后的尾节点（直接不停right找即可，可以先不管left），然后把右边拼到后面，再把左节点挪到右节点，继续前进循环
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                cur = cur.right;
                continue;
            }

            // 先序遍历的尾节点是最右边那个
            TreeNode tail = cur.left;
            while(tail.right != null) {
                tail = tail.right;
            }

            tail.right = cur.right;
            cur.right = cur.left;
            cur.left = null;
        }
    }

//    static TreeNode flattenRec(TreeNode root) {
//        if(root == null) return null;
//        if(root.left == null && root.right == null) return root;
//
//        if(root.left == null) {
//            // 如果本身left空，只要继续下一级铺右节点即可
//            flattenRec(root.right);
//            return root.right;
//        } else {
//            TreeNode leftHead = root.left;
//            TreeNode right = root.right;
//            // 递归展开左节点，并记录链尾
//            TreeNode leftTail = flattenRec(root.left);
//            root.right = leftHead;
//            leftTail.right = right;
//            return leftTail;
//        }
//        // FIXME: 2023/8/16 递归纪要返回根节点又要返回尾节点，无法实现
//    }

//    static void flatten(TreeNode root) {
//        // 思路：要求是按先序中左右展开成一个右树单链表
//        // 每个节点的中左右需要变成，中+右+右右，所以考虑先用递归，让左节点变成右节点，再让原右节点变成新右节点的右节点
//        if(root == null) return;
//        // 左节点没有的话，不用处理
//        if(root.left == null) return;
//        // 右节点如果为空，直接左节点挪到右节点，否则链到下一个
//        if(root.right == null) {
//            root.right = root.left;
//        } else {
//            TreeNode oldRight = root.right;
//            root.right = root.left;
//            root.right.right = oldRight;
//        }
//        // 依次递归处理下一个节点
//        // FIXME: 2023/8/16 大方向ok，细节错误，左右交换的话右节点应该接到左节点的末位置
//    }

}
