package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/6 9:48
 * @description
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        //向中间移动，更新最大容量值
        //left:i指针向右移动的过程中，如果height[i] >= height[leftH],则leftH = i
        int i = 0,j = len - 1;
        int maxArea = 0;
        while(i < j){
            //更新area
            int area = (j - i) * Math.min(height[i],height[j]);
            maxArea = Math.max(area,maxArea);
            //更新i和j
            //较小的那个高度，不会再作为任何边界的可能
            //1、无论另一侧的高度如何变化，面积的高度只可能会减小，不会增大
            //2、两个高度之间的距离越来越小
            //综上，较低的高度直接舍弃
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
