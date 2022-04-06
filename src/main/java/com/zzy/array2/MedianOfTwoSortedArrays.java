package com.zzy.array2;

/**
 * @ClassName MedianOfTwoSortedArrays
 * @Date 2022/4/6 20:46
 * @Author Admin
 * @Description
 */
public class MedianOfTwoSortedArrays {

    //方法1：二分（数组有序）
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组数目之和为奇数或者偶数
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 == 1) {
            //直接返回第 (len1+len2)/2 = 7/2 = 3 + 1小
            return getKthMinNum(nums1, nums2, (len1 + len2) / 2 + 1);
        } else {
            int a = getKthMinNum(nums1, nums2, (len1 + len2) / 2);
            int b = getKthMinNum(nums1, nums2, (len1 + len2) / 2 + 1);
            return (a + b) / 2.0;
        }
    }

    //二分k
    private int getKthMinNum(int[] nums1, int[] nums2, int k) {
        //初始逻辑下标
        int index1 = 0;
        int index2 = 0;

        while (true) {

            //处理边界条件
            //若一个数组到达末尾，则返回另一个数组的第k小
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                //返回 逻辑首位 的最小值
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + half, nums2.length) - 1;
            int povit1 = nums1[newIndex1];
            int povit2 = nums2[newIndex2];
            //更新k
            if (povit1 <= povit2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }

    }

}
