package com.zzy.array;

import java.util.*;

/**
 * @author ZZy
 * @date 2022/4/17 13:15
 * @description
 */
public class NQueens {
    Set<Integer> colSet;
    Set<Integer> posSet;
    Set<Integer> negSet;

    //方法1：回溯
    //关键：将列和2个斜行的数据特征提取出来，并找出一个数据结构存储
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        colSet = new HashSet<>();
        posSet = new HashSet<>();
        negSet = new HashSet<>();
        dfs(res,0,n,new ArrayList<String>());
        return res;
    }

    private void dfs(List<List<String>> res, int i, int n, ArrayList<String> list) {
        if (i == n) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (colSet.contains(j) || posSet.contains(i + j) || negSet.contains(i - j)) {
                continue;
            }
            posSet.add(i + j);
            negSet.add(i - j);
            colSet.add(j);

            char[] s = new char[n];
            Arrays.fill(s,'.');
            s[j] = 'Q';
            list.add(new String(s));
            dfs(res, i + 1, n, list);
            list.remove(list.size() - 1);
            posSet.remove(i + j);
            negSet.remove(i - j);
            colSet.remove(j);
        }
    }

}
