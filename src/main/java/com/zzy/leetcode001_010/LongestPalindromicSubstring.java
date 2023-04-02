/**
 * @program: leetcode4
 * @description:
 * @author: zzy
 * @create: 2023-04-01
 */
package com.zzy.leetcode001_010;

public class LongestPalindromicSubstring {
    public String getLongestPalindromic(String s) {
        //数据结构？ 动态规划
        //验证有效性
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int maxL = 1, maxIdx = 0;
        boolean[][] isPalindrome = new boolean[len][len];
        //初始化
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        char[] chars = s.toCharArray();
        //递推   dp[i][j]
        for (int L = 1; L < s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                //依次检验以i开始的L长度的字符串   j - i + 1 = L, j = L - 1 + i
                int j = L - 1 + i;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    isPalindrome[i][j] = false;
                } else {
                    //i、j之间的字符只有1个
                    if (j - i + 1 < 4) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
                //更新dp[i][j]
                if (isPalindrome[i][j] && j - i + 1  > maxL) {
                    maxL = j - i + 1;
                    maxIdx = i;
                }

            }
        }
        return s.substring(maxIdx, maxIdx+maxL);
    }


}