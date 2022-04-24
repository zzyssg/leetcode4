package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/17 16:45
 * @description
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            //i在能达到的最远范围内，可以更新rightMost
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
