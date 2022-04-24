package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/11 11:17
 * @description
 */
public class TrappingRainWater {
    //方法1：双指针
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        //关键点：此时左右两侧初始化为各自目前的最大值
        int leftMax = height[left], rightMax = height[right];
        //在while的循环中，固定不动的某一端如leftMax==left，
        // 除非right--直到找到right，height[right]==rightMax>height[left]==leftMax
        while (left <= right) {
            //移动的过程中，寻找左右两边的最大值
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                //right不动，意味着height[right] <= rightMax
                left++;
            } else {
                //更新right，
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
