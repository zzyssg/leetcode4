package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/9 13:21
 * @description
 */
public class FindFirstAndLastElementInSortedArray {

    //方法1：二分法
    public int[] searchRange(int[] nums, int target) {
        int idx1 = getLocation(nums, target, true);
        int idx2 = getLocation(nums, target, false) - 1;
        if (idx1 <= idx2 && idx2 < nums.length && nums[idx1] == target && nums[idx2] == target) {
            return new int[]{idx1, idx2};
        }
        return new int[]{-1,-1};

    }

    private int getLocation(int[] nums, int target, boolean bgAndEql) {
        int l = 0, r = nums.length - 1;
        int res = nums.length;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target || (bgAndEql && nums[mid] >= target)) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
