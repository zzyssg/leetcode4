/**
 * @program: leetcode4
 * @description: 周期性--用余数
 * @author: zzy
 * @create: 2023-04-02
 */
package com.zzy.leetcode001_010;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int n) {
        //方法1 矩阵模拟 时间：O(r*N) 空间：O(r*N) ,r为行数，n为字符串长度
        //知识点：向上取整、周期相关用取模运算
        //行：n ，列：s.len / 2   周期：  t = s.len/ (n + n - 2)   周期列：1 + n - 2 = n - 1
        if (s == null) {
            return s;
        }
        if (n == 1 || s.length() < n) {
            return s;
        }
        int len = s.length();
        //向上取整  找周期个数
        int T = n + n - 2;
        int totalColumn = (len + T - 1) / T * (1 + n - 2);
        char[][] chars = new char[n][totalColumn];
        //模拟 :i<n - 1时i++,i == n - 1时，i--,j++
        for (int idx = 0,i = 0, j = 0; idx < len; idx++) {
            chars[i][j] =s.charAt(idx);
            if (idx % T < n - 1) {
                i++;
            } else {
                i--;
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] cs : chars) {
            for (char c : cs) {
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    //方法2 ：方法1中浪费了大量空间，且空内容不会使用。将二维矩阵拆分为多个列表
    //时间： O(N)  空间：O(N)
    public String convert2(String s, int row) {
        if (s == null || row == 1 || s.length() < row) {
            return s;
        }
        int T = row + row - 2;
        StringBuilder[] mat = new StringBuilder[row];
        for (int i = 0; i < s.length(); i++) {
            mat[i] = new StringBuilder();
        }
        for (int i = 0, n = 0; i < s.length(); i++) {
            mat[n].append(s.charAt(i));
            if (i % T < row - 1) {
                n++;
            } else {
                n--;
            }
        }
        String res = "";
        for (StringBuilder sb : mat) {
            res += sb;
        }
        return res;
    }

//    public static void main(String[] args) {
//        ZigzagConversion zigzagConversion = new ZigzagConversion();
//        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3));
//
//    }
}