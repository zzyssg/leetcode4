package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/17 15:18
 * @description
 */
public class MaximumSubarray {
    //方法1：贪心
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    //方法2：动态规划
    public int maxSubArray2(int[] nums) {
        //dp[i]：以num[i]结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
