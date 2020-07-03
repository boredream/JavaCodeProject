package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;
import com.sun.xml.internal.bind.v2.TODO;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeDeserializeTree {

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1; // 计数变量

    TreeNode Deserialize(String str) {
        index++;
        String[] strList = str.split(",");
        TreeNode node = null;
        if (!strList[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strList[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        // TODO 有点难理解
        return node;
    }

    public static void main(String[] args) {
        // 思路1：tree2str简单，基本就是各种前中后序遍历。但是str2tree构造过程有待思考
        // 应该是按照前序 根-左-右，这样才能从头开始一个一个构建

        SerializeDeserializeTree sdt = new SerializeDeserializeTree();
        //       8
        //    /    \
        //   6      10
        //    \     / \
        //     7   9  11
        TreeNode node = TreeNode.test();
        node.left.left = null;
        String serialize = sdt.Serialize(node);
        System.out.println(serialize);
        System.out.println(sdt.Deserialize(serialize));

    }

}
