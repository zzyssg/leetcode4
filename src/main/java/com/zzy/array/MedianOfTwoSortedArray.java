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

    //方法2：二分
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //第k小的数
        if((m + n) % 2 == 1){
            return getKthMinNum(nums1,nums2,(m+n)/2 + 1);
        }else{
            return (getKthMinNum(nums1,nums2,(m+n)/2) + getKthMinNum(nums1,nums2,(m+n)/2+1)) * 0.5;
        }
    }

    private int getKthMinNum(int[] nums1,int[] nums2,int k){

        //逻辑上的首位下标
        int index1 = 0;
        int index2 = 0;

        //特殊边界
        while(true){
            if(index1 == nums1.length){
                return nums2[index2 + k - 1];
            }
            if(index2 == nums2.length){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k  / 2;
            int pIndex1 = Math.min(index1 + half,nums1.length) - 1;
            int pIndex2 = Math.min(index2 + half,nums2.length) - 1;
            int povit1 = nums1[pIndex1];
            int povit2 = nums2[pIndex2];
            //缩小k值,更新逻辑首位
            if(povit1 <= povit2){
                k -= (pIndex1 - index1 + 1);
                index1 = pIndex1 + 1;
            }else{
                k -= (pIndex2 - index2 + 1);
                index2 = pIndex2 + 1;
            }
        }
    }

}
