package com.zzy.year2024;

/**
 * @ClassName FindMedianInSortedArrays
 * @Author ZZy
 * @Date 2024/1/24 16:27
 * @Description
 * @Version 1.0
 */
public class C004_FindMedianInSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //找到第k小的数
        int len1 = nums1.length;
        int len2 = nums2.length;
        int k = (len1 + len2) / 2;
        if ((len1 + len2) % 2 == 1) {
            return getKthMinNum(nums1, nums2, k + 1);
        } else {
            return (getKthMinNum(nums1, nums2, k) +
                    getKthMinNum(nums1, nums2, k + 1)) * 0.5;
        }

    }

    //得到第K小的数
    private int getKthMinNum(int[] nums1, int[] nums2, int k) {
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            //k是可变的，第k小
            if (idx1 >= nums1.length) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 >= nums2.length) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, nums1.length) - 1;
            int newIdx2 = Math.min(idx2 + half, nums2.length) - 1;
            //数组1的中位数小
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
