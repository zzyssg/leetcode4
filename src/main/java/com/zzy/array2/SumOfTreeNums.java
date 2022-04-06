package com.zzy.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SumOfTreeNums
 * @Date 2022/4/6 21:21
 * @Author Admin
 * @Description
 */
public class SumOfTreeNums {

    //方法1：排序+双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //if 优化
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    //去重
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

}
