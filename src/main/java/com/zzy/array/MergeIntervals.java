package com.zzy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZZy
 * @date 2022/4/17 17:15
 * @description
 */
public class MergeIntervals {

    //方法1：排序
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][2];
        }
        //排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] nums1,int[] nums2){
                return nums1[0] - nums2[0];
            }
        });
        //合并
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                list.add(intervals[i]);
            } else {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
