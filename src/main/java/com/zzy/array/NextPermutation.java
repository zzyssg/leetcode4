package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/8 9:18
 * @description
 */
public class NextPermutation {
    //方法1：双指针
    public void nextPermutation(int[] nums) {
        //i代表较小值，j代表较大值
        //从右向左遍历，找到nums[i] < nums[i + 1],j为较小值,[i + 1,n] 是降序
        //从右向左遍历,找到nums[j] > nums[i],j为较大值，j必存在
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //若i < 0，则说明全为降序，直接reverse,否则找到较大值
        if(i >= 0){
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
