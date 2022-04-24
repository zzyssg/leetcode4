package com.zzy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/13 17:38
 * @description
 */
public class Permutations2 {
    //方法1：回溯 + 访问数组
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //排序 - 去重
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0, res, new ArrayList<Integer>());
        return res;

    }

    private void dfs(int[] nums, boolean[] visited, int index, List<List<Integer>> res, ArrayList<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] =true;
            list.add(nums[i]);
            dfs(nums, visited, index + 1, res, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
