package com.zzy.year2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SumOfTwoNum
 * @Author ZZy
 * @Date 2024/1/22 22:56
 * @Description 两数之和：给一数组，数字不重复。给一和t，找出和为t的2数的数组下标，并返回
 * @Version 1.0
 */
public class C001_SumOfTwoNum {
    //sol1 双层循环 时间复杂度：O(n^2)  空间复杂度：O(1)
    public int[] twoSum1(int[] nums,int target){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    //sol2: hashMap 时间复杂度：O(n)   空间复杂度：O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (numIndexMap.containsKey(minus)) {
                return new int[]{i, numIndexMap.get(minus)};
            } else {
                numIndexMap.put(nums[i], i);
            }
        }
        return new int[]{};

    }

}


