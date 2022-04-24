package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/15 16:39
 * @description
 */
public class RotateImage {
    //方法1：找规律
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j <= (n - 1) / 2; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[n - 1 -j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tem;
            }
        }
    }
}
