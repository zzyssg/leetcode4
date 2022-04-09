package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/8 8:06
 * @description
 */
public class RemoveElement {

    //方法1：双指针
    public int removeElement(int[] nums, int val) {
        //i代表即将被取代的位置，j代表取代的位置，i的位置被取代时，j直接覆盖
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                //j位置的元素换过来后，仍要检测
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }
}
