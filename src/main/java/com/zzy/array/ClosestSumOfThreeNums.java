package com.zzy.array;

import java.util.Arrays;

/**
 * @author ZZy
 * @date 2022/4/6 14:09
 * @description
 */
public class ClosestSumOfThreeNums {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        //记录结果
        int res = 0;
        //记录距离
        int distance = Integer.MAX_VALUE;
        //双指针注意数组的顺序
        Arrays.sort(nums);
        for(int i = 0;i < n - 2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1,k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                //如果和sum相等，直接返回
                if (sum == target) {
                    return sum;
                }
                //处理不等的情况:更新距离+更新对应的sum
                if(Math.abs(sum - target) < distance){
                    distance = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) {
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                } else{
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
        }
        return res;
    }

}
