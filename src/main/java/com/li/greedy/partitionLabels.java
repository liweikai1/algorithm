package com.li.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/05/20/15:40
 * @Description:leetcode T763 题目：划分字母区间
 题目：
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
返回一个表示每个字符串片段的长度的列表。

示例：
    输入：S = "ababcbacadefegdehijhklij"
    输出：[9,7,8]
    解释：
        划分结果为 "ababcbaca", "defegde", "hijhklij"。
        每个字母最多出现在一个片段中。
        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

 */
public class partitionLabels {
    //贪心算法
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij" ;
        List<Integer> partitionLabels = partitionLabels(s);
        System.out.println(partitionLabels);
    }
    //在遍历的过程中相当于是要找每⼀个字⺟的边界，如果找到之前遍历过的所有字⺟的最远边界，
    // 说明这个边界就是分割点了。此时前⾯出现过所有字⺟，最远也就到这个边界了。
    //解题过程可以分为如下两步：
    // 1.统计每⼀个字符最后出现的位置
    // 2.从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，
    //   则找到了分割点
    public static List<Integer> partitionLabels(String s) {
        int[] position = new int[26] ;
        for (int i = 0 ; i < s.length() ; i++){
            position[s.charAt(i) - 'a'] = i ;
        }
        List<Integer> list = new ArrayList<>() ;
        int start = 0 , end = 0 ;
        for (int i = 0 ; i < s.length() ; i++){
            end = Math.max(end , position[s.charAt(i) - 'a']) ;
            if (end == i){
                list.add(end - start + 1) ;
                start = end + 1 ;
            }

        }
        return list ;
    }
}
