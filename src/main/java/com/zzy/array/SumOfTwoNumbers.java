package com.zzy.array;

import java.util.HashMap;

/**
 * @author ZZy
 * @date 2022/4/5 17:06
 * @description
 */
public class SumOfTwoNumbers {
    //方法1：哈希
    //时间复杂度：O(N)。对于每一个元素，可以用O(1)的时间找到。循环N次。
    //空间复杂度：O(N)。对于最坏的情况下，找到最后一个元素才能找到匹配项，将所有的元素都放进了map。
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int tem = target - nums[i];
            if(map.containsKey(tem)){
                return new int[]{i,map.get(tem)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
