package com.zzy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/6 13:21
 * @description
 */
public class SumOfThreeNums {
    //当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法
    //每一层的nums[i - 1] == nums[i] = a的话，因为是从小到大排列，前者已经把第一位是a的排列都罗列了，所以不需要第二次出现
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //O(Nlog(N))
        Arrays.sort(nums);
        int len = nums.length;
        //O(N^2)
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1,k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temList = new ArrayList<>();
                    temList.add(nums[i]);
                    temList.add(nums[j]);
                    temList.add(nums[k]);
                    res.add(temList);
                    //出去的j值仍是旧值，k同
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    //sum == 0,i、j同时更新
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
