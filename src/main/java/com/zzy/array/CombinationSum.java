package com.zzy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/10 12:03
 * @description
 */
public class CombinationSum {
    //无重复元素
    //方法1：回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<Integer>(), 0, res, target);
        return res;



    }

    private void dfs(int[] candidates, ArrayList<Integer> list, int idx, List<List<Integer>> res, int target) {
        //出口
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        //直接跳过idx  —— 会有某条路径全部跳过，idx一直up，超过candidates.length后一直up
        dfs(candidates, list, idx + 1, res, target);
        //使用idx
        if (target - candidates[idx] >= 0) {
            list.add(candidates[idx]);
            //因为可以重复选择，所以选取后，仍然可供选择，仅仅是target改变
            dfs(candidates, list, idx, res, target - candidates[idx]);
            list.remove(list.size() - 1);
        }

    }

}
