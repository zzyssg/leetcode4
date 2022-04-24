package com.zzy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InsertInterval
 * @Date 2022/4/24 21:27
 * @Author Admin
 * @Description
 */
public class InsertInterval {

    //方法1：模拟插入
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        //合并区间边界
        int left = newInterval[0];
        int right = newInterval[1];
        //是否遇到右边界
        boolean placed = false;
        for (int[] interval : intervals) {
            if (left > interval[1]) {
                list.add(interval);
            } else if (right < interval[0]) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    //到达过右边界
                    placed = true;
                }
                list.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        //若循环中未遇到右边界
        if (!placed) {
            list.add(new int[]{left,right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
