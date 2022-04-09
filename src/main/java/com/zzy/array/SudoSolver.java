package com.zzy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/9 16:45
 * @description
 */
public class SudoSolver {

    //某行的某个数是否已经存在
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] boxes = new boolean[3][3][9];
    private boolean isValid = false;
    private List<int[]> space = new ArrayList<>();
    //方法1：递归 + 回溯
    public void solveSudoku(char[][] board) {

        //找到空格
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    space.add(new int[]{i,j});
                }else{
                    int index = c - '1';
                    rows[i][index] = cols[j][index] = boxes[i / 3][j / 3][index] = true;
                }
            }
        }
        //回溯
        dfs(board, 0);

    }

    private void dfs(char[][] board, int pos) {
        if (pos == space.size()) {
            isValid = true;
            return;
        }
        int[] sp = space.get(pos);
        int i = sp[0], j = sp[1];
        //对空格尝试 0-8 即 '1' - '9'
        for (int k = 0; k < 9 && !isValid; k++) {
            if (!rows[i][k] && !cols[j][k] && !boxes[i / 3][j / 3][k]) {
                //尝试使用k
                rows[i][k] = cols[j][k] = boxes[i / 3][j / 3][k] = true;
                board[i][j] =(char) (k + '1');
                dfs(board, pos + 1);
                rows[i][k] = cols[j][k] = boxes[i / 3][j / 3][k] = false;
            }
        }
    }
}
