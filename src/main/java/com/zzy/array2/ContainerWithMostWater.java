package com.zzy.array2;

/**
 * @ClassName ContainerWithMostWater
 * @Date 2022/4/6 21:14
 * @Author Admin
 * @Description
 */
public class ContainerWithMostWater {

    //方法1：双指针
    public int maxArea(int[] height) {
        //记录中间的最大面积
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[r],height[l]);
            maxArea = Math.max(area, maxArea);
            //小的边直接淘汰，不可能会作为以后的边
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
