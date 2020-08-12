package com.boredream.entity;

public class DataFactory {

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

}
