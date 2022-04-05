package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/5 17:20
 * @description
 */
public class MedianOfTwoSortedArray {

    //若为奇数个数字，则取（m+n+1）/ 2;若为偶数个数字，则取 （m+n-1）/ 2,(m+n)/2的平均值

    //方法1：合并+取中值
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int i = 0,j = 0,k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums[j]) {
                nums[k] = nums1[i++];
            } else {
                nums[k] = nums2[j++];
            }
            k++;
        }
        while (i != m) {
            nums[k++] = nums1[i++];
        }
        while (j != n) {
            nums[k++] = nums2[j++];
        }
        //取值
        if ((m + n) % 2 == 0) {
            //偶数个： (m+n-1) (m+n)平均值
            int num1 = nums[m + n - 1];
            int num2 = nums[m + n];
            return (num1 + num2) / 2.0;
        } else {
            return nums[(m + n + 1) / 2];
        }
    }

}
