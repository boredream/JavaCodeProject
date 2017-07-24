package com.boredream.leetcode;

import com.boredream.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunyang on 2017/7/24.
 */
public class AverageOfLevelsInBinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        List<Double> doubles = averageOfLevels(root);
        for (Double d : doubles) {
            System.out.println(d);
        }
    }

    static List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();
        calculateAverageOfLevel(answer, counter, 0, root);
        for (int i = 0; i < answer.size(); i++) {
            answer.set(i, answer.get(i) / counter.get(i));
        }
        return answer;
    }

    static void calculateAverageOfLevel(List<Double> answer, List<Integer> counter, int level, TreeNode root) {
        if(root == null) return;
        if(answer.size() <= level) {
            answer.add((double) root.val);
            counter.add(1);
        } else {
            answer.set(level, answer.get(level) + root.val);
            counter.set(level, counter.get(level) + 1);
        }
        calculateAverageOfLevel(answer, counter, level+1, root.left);
        calculateAverageOfLevel(answer, counter, level+1, root.right);
    }
}
