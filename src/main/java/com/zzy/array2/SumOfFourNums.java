package com.zzy.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SumOfFourNums
 * @Date 2022/4/6 21:44
 * @Author Admin
 * @Description
 */
public class SumOfFourNums {

    //方法1：排序 + 双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        //可能会整型溢出
        for (int i = 0; i < len - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //优化
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            //双指针
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1, q = len - 1;
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p]);
                        list.add(nums[q]);
                        res.add(list);
                        while (p < q && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        while (p < q && nums[q] == nums[q - 1]) {
                            q--;
                        }
                        p++;
                        q--;
                    } else if (sum > target) {
                        q--;
                    } else {
                        p++;
                    }
                }

            }

        }
        return res;
    }

}
