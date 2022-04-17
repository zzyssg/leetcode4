package com.zzy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/17 16:00
 * @description
 */
public class SpiralMatrix {
    //方法1：模拟旋转
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, m = matrix.length - 1, n = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while(i <= m && j <= n){
            rotate(matrix,i,j,m,n,list);
            i++;
            j++;
            m--;
            n--;
        }
        return list;
    }

    private void rotate(int[][] matrix, int iIndex, int jIndex, int mIndex, int nIndex, List<Integer> list) {
        //i行
        for (int j = jIndex; j <= nIndex; j++) {
            list.add(matrix[iIndex][j]);
        }
        //n列
        for (int i = iIndex + 1; i <= mIndex; i++) {
            list.add(matrix[i][nIndex]);
        }
        //假如只有一行或者一列，则不用则继续add
        if (iIndex == mIndex || jIndex == nIndex) {
            return;
        }
        //m行
        for (int j = nIndex - 1; j >= jIndex; j--) {
            list.add(matrix[mIndex][j]);
        }
        //j列
        for (int i = mIndex - 1; i > iIndex; i--) {
            list.add(matrix[i][jIndex]);
        }

    }
}
