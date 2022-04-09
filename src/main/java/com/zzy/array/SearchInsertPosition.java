package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/9 14:00
 * @description
 */
public class SearchInsertPosition {
    //方法1：二分法
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

}
