package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/11 10:22
 * @description
 */
public class FirstMissingPositive {
    //方法1：交换 将数据x放到位置x-1处，然后遍历
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]- 1]){
                swap(nums,i,nums[i] - 1);
            }
        }
        for(int i = 0;i < nums.length;i++){
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 1- N 均不存在
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
