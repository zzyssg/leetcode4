package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/10 17:02
 * @description
 */
public class Combination4 {
    //方法1：动态规划
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        //边界
        dp[0] = 1;
        for (int sum = 1; sum <= target; sum++) {
            for (int num : nums) {
                //<=
                if (num <= sum) {
                    //dp[sum - num] : 和为sum-num的数目
                    dp[sum] += dp[sum - num];
                }
            }
        }
        return dp[target];
    }
}
