package com.zzy.year2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName C003_LengthOfLongstSubstring
 * @Author ZZy
 * @Date 2024/1/24 15:17
 * @Description
 * @Version 1.0
 */
public class C003_LengthOfLongestSubstring {

    //    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int max = 0;
//        Set set = new HashSet();
//        //双指针
//        for (int i = 0; i < s.length(); i++) {
//            //计算以i开头的最长子串的长度,i逐渐增大
//
//            int j = i;
//            while (j < s.length() && !set.contains(s.charAt(j))) {
//                set.add(s.charAt(j));
//                j++;
//            }
//            set.remove(s.charAt(i));
//            max = Math.max(max, j - i);
//        }
//
//
//    }
    //滑动窗口 时间复杂度：O(n) 空间复杂度：O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        //存储字符对应的index
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //滑动窗口出现这个值
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1); //向右移动一位
            }
            //窗口中未出现
            map.put(s.charAt(i), i);
            //更新最大值
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
