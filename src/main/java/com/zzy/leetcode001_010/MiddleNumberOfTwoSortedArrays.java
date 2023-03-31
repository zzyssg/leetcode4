/**
 * @program: leetcode4
 * @description:   方法1：二分法 分奇偶
 * @author: zzy
 * @create: 2023-03-31
 */
package com.zzy.leetcode001_010;

public class MiddleNumberOfTwoSortedArrays {

    public double midNum(int[] nums1, int[] nums2) {
        //二分法
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if ((len1 + len2) % 2 == 0) {
            int midIdx1 = len / 2 - 1;
            int midIdx2 = midIdx1 + 1;
            return (getKthMinNum(nums1, nums2, midIdx1 + 1) +
                    getKthMinNum(nums1, nums2, midIdx2 + 1)) * 0.5;
        } else {
            int midIdx = len / 2;
            return getKthMinNum(nums1, nums2, midIdx + 1);
        }
    }

    //得到第n小的数字
    private int getKthMinNum(int[] nums1, int[] nums2, int k) {
        int idx1 = 0;
        int idx2 = 0;

        while (true) {
            //特殊情况
            if (idx1 == nums1.length) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == nums2.length) {
                return nums1[idx1 + k - 1];
            }
            if (nums1[idx1] == nums2[idx2]) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            //一般情况
            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, nums1.length) - 1;
            int newIdx2 = Math.min(idx2 + half, nums2.length) - 1;
            if (nums1[newIdx1] < nums2[newIdx2]) {
                k = k - (newIdx1 - idx1 + 1);
                idx1 = newIdx1 + 1;
            } else {
                k = k - (newIdx2 - idx2 + 1);
                idx2 = newIdx2 + 1;
            }
        }
    }

}