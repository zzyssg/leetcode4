package com.zzy.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/13 16:57
 * @description
 */
public class Permutations {
    //方法1：回溯 + 访问指针
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, visited, res, new ArrayList<Integer>());
        return res;

    }

    private void dfs(int[] nums, int index, boolean[] visited, List<List<Integer>> res, ArrayList<Integer> list) {
        //出口
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        //回溯
        //返回的数据以字典序排列
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, index + 1, visited, res, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    //方法2：回溯 + 不用访问指针
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //预处理
        for (int num : nums) {
            list.add(num);
        }
        backtracking(nums, 0, list, res);
        return res;
    }

    //不保证输出的字典顺序，输出顺序和输入顺序有关
    private void backtracking(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            Collections.swap(list, index, i);
            backtracking(nums, index + 1, list, res);
            Collections.swap(list, index, i);
        }
    }
}
