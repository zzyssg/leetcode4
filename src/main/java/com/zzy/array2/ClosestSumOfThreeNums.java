package com.zzy.array2;

import java.util.Arrays;

/**
 * @ClassName ClosestSumOfThreeNums
 * @Date 2022/4/6 21:32
 * @Author Admin
 * @Description
 */
public class ClosestSumOfThreeNums {

    //方法1：排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        //用res记录结果，distance记录距离
        int res = 0;
        int distance = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                //若直接命中
                if (sum == target) {
                    return sum;
                }
                //记录最接近的值，同时更新distance
                int absD = Math.abs(sum - target);
                if (absD < distance) {
                    res = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return res;
    }

}
