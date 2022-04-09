package com.zzy.array;

/**
 * @author ZZy
 * @date 2022/4/7 8:35
 * @description
 */
public class RemoveDuplicatesFromSortedArray {

    //方法1：双指针
    //指针i代表被覆盖（而非替换）的位置，指针j代表和前面不同的位置
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0,j = 1;
        while (j < nums.length) {
            //找到和前面不一样的j
            while (j < nums.length && nums[j] == nums[j - 1]) {
                j++;
            }
            if (j == nums.length) {
                break;
            }
            //覆盖而非交换
            //nums[++i] = nums[j++]; // 下面这种写法用时更少
            i++;
            nums[i] = nums[j];
            j++;
        }
        return i + 1;
    }

}
