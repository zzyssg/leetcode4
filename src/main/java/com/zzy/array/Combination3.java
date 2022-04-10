package com.zzy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/10 15:28
 * @description 216
 *
 */
public class Combination3 {
    public List<List<Integer>> combinationSum3(int k, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, sum, k, 1, new ArrayList<Integer>());
        return res;
    }

    //sum : 剩余sum ，k还剩几个数可以用 ， start：本次起始index
    private void dfs(List<List<Integer>> res, int sum, int k, int start, ArrayList<Integer> list) {
        //没有数字可以使用
        if (k < 0) {
            return;
        }
        //检验本次填入的数字
        if (k == 0 && sum == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        //回溯
        for (int i = start; i < 10; i++) {
            list.add(i);
            dfs(res, sum - i, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
