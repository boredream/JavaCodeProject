package com.boredream.entity;

import java.util.LinkedList;
import java.util.Queue;

public class DataFactory {

    public static void main(String[] args) {
        printMatrix(createMatrix());
    }

    public static int[][] createMatrix() {
        return new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static char[][] createSudoku() {
        return new char[][]{
                {'5','3','.', '.','7','.', '.','.','.'},
                {'6','.','.', '1','9','5', '.','.','.'},
                {'.','9','8', '.','.','.', '.','6','.'},

                {'8','.','.', '.','6','.', '.','.','3'},
                {'4','.','.', '8','.','3', '.','.','1'},
                {'7','.','.', '.','2','.', '.','.','6'},

                {'.','6','.', '.','.','.', '2','8','.'},
                {'.','.','.', '4','1','9', '.','.','5'},
                {'.','.','.', '.','8','.', '.','7','9'},
        };
    }

    public static void printSudoku(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
                if ((j + 1) % 3 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}
