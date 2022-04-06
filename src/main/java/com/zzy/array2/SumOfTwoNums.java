package com.zzy.array2;

import java.util.HashMap;

/**
 * @ClassName SumOfTwoNums
 * @Date 2022/4/6 20:40
 * @Author Admin
 * @Description
 */
public class SumOfTwoNums {
    //方法1：哈希
    //时间复杂度：O(N)
    //空间复杂度：O(N)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[]{i, map.get(left)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
