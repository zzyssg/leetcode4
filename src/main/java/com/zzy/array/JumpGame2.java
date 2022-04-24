package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/13 10:38
 * @description
 */
public class JumpGame2 {
    //方法1：贪心
    public int jump(int[] nums) {
        int cnt = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(i + nums[i], maxPos);
            //达到本次能跳到的最远点
            //如果不在此之前更新maxPos，则第一次i == 0时，end仍然==0，则以后的 i!= 0恒成立，则不会进入此代码块cnt恒为1
            if (i == end) {
                //起跳 起跳前需要知道起跳后能到达的最大位置
                cnt++;
                end = maxPos;
            }
        }
        return cnt;
    }
}
