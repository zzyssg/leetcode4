/**
 * @program: leetcode4
 * @description:    两种解法：1、hashMap 2、暴力for循环
 * @author: zzy
 * @create: 2023-03-27
 */
package com.zzy.leetcode001_010;

import java.util.HashMap;

public class SumOfTwoNum {
    public int[] twoSum(int[] nums,int target) {
        // case1 hashMap，key为num，val为index
        int[] res = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.isEmpty()) {
                hashMap.put(target - nums[i],i);
                continue;
            }
            if (hashMap.containsKey(nums[i])) {
                res[0] = i;
                res[1] = hashMap.get(nums[i]);
                break;
            } else {
                hashMap.put(target - nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        SumOfTwoNum sum = new SumOfTwoNum();
        int[] res = sum.twoSum(nums, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println(res);
    }

}