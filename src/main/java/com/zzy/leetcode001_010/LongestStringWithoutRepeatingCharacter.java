/**
 * @program: leetcode4
 * @description: 方法1：右边界始终在左边界右侧（或者重合），适用于滑动窗口
 *              方法2：动态规划   hard
 * @author: zzy
 * @create: 2023-03-31
 */
package com.zzy.leetcode001_010;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeatingCharacter {
    public int longestLength(String str) {
        //排除空
        if (str == null || str.length() == 0) {
            return 0;
        }
        int res = 0;
        Set<Character> set = new HashSet<>();
        //右指针j一定不会减小
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            //左指针向右移一位，删除上次i的字符
            if (i != 0) {
                set.remove(str.charAt(i - 1));
            }
            //以本次i为起始的最长字符串的长度
            while (j < str.length() && !set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                j++;
            }
            res = Math.max(res, set.size());
        }
        return res;
/** 方法二：动态规划
        int m = s.length();
        if(m==0) {
            return 0;
        }
        int num =1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max =1;
        for(int i=1;i<m;i++){
            int index = s.indexOf(s.charAt(i),i-num);
            if(index<i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i-index;
            } else {
                num = num+1;
            }
            max = Math.max(max,num);
        }
        return max;
*/

    }
}