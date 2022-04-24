package com.zzy.array;

/**
 * @ClassName SpiralMatrix2
 * @Date 2022/4/24 22:17
 * @Author Admin
 * @Description
 */
public class SpiralMatrix2 {
    //方法1：模拟旋转
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] res = new int[n][n];
        int dir = 0;
        int curCol = 0,curRow = 0;
        while (curNum <= maxNum) {
            res[curRow][curCol] = curNum;
            int nextRow = curRow + directions[dir][0];
            int nextCol = curCol + directions[dir][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0) {
                dir = (dir + 1) % 4;
            }
            curRow = curRow + directions[dir][0];
            curCol = curCol + directions[dir][1];
            curNum++;
        }
        return res;
    }

}
