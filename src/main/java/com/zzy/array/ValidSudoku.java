package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/9 15:05
 * @description
 */
public class ValidSudoku {
    //方法2：用多维数组模拟集合
    public boolean isValidSudoku(char[][] board) {
        //最后一维代表‘1’-‘9’出现的字符次数
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    rows[i][index]++;
                    cols[j][index]++;
                    boxes[i / 3][j / 3][index]++;
                    //或
                    if (rows[i][index] > 1 || cols[j][index] > 1 || boxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
