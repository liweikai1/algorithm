package com.li.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/22/21:00
 * @Description:leetcode:T78 题目：子集
 题目描述：
给你一个整数数组 nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。
解集不能包含重复的子集。你可以按任意顺序返回解集。

示例 1：
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class subsets {
    //使用回溯算法
    private static List<List<Integer>> list  ;

    public static void main(String[] args) {
        int[] nums = {1,2,3} ;
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>() ;
        if(nums == null){
            return list ;
        }
        backTrack(nums , 0 , new ArrayList<>());
        return list ;
    }
    public static void backTrack(int[] nums , int index , List<Integer> res){
        list.add(new ArrayList<>(res)) ;
        for(int i = index ; i < nums.length ; i++){
            res.add(nums[i]) ;
            backTrack(nums , i+1 , res) ;
            res.remove(res.size() - 1);
        }
    }
}
