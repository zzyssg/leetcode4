package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/9 12:27
 * @description
 */
public class SearchInRotatedSortedArray {

    //方法1：二分法
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            }
            //若左侧有序
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid + 1] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

        }

        return -1;
    }
}
