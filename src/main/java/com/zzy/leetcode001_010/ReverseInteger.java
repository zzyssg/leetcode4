/**
 * @program: leetcode4
 * @description:
 * @author: zzy
 * @create: 2023-04-02
 */
package com.zzy.leetcode001_010;

public class ReverseInteger {
    public Integer reverse(Integer x) {
        //1、对于越界的数字如何界定  余数和除数与 MAX_VALUE和MIN_VALUE相比较
        //2、如何实现反转  通过字符串？  求余数 然后 余数*10=》 弹出余数，推入高位数
        //3、java的除法，与除数无关，与被除数有关。符号取被除数，数字取二者绝对值得余数。结果：余数+商*除数=被除数
        int res = 0;
        int left;
        while (x != 0) {
            //弹出最后一位，推入翻转的数字
            left = x % 10;
            //越界
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE && left > Integer.MAX_VALUE % 10) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE && left < Integer.MIN_VALUE % 10) {
                return 0;
            }
            //翻转
            res = res * 10 + left;
            x = x / 10;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}