package com.li.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/26/15:58
 * @Description:leetcode T40 题目：组合总和 II
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和
为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。
注意：解集不能包含重复的组合。

示例 2:
    输入: candidates = [2,5,2,1,2], target = 5,
    输出:
    [[1,2,2],
    [5]]
 */
public class combinationSum2 {
    private static List<List<Integer>> list = new ArrayList<>() ;
    private static List<Integer> res = new ArrayList<>() ;

    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2} ;
        int target = 5 ;
        List<List<Integer>> combinationSum2 = combinationSum2(nums, target);
        System.out.println(combinationSum2);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null) return list ;
        Arrays.sort(candidates) ;
        backTrack(candidates , target , 0) ;
        return list ;
    }
    //如何找到剪枝条件：
    //分析：先对数组进行升序排序，重复的元素一定不是排好序以后相同的连续数组区域的第1个元素。
    //也就是说，剪枝发生在：同一层数值相同的结点第 2、3 ... 个结点，因为数值相同的第1个结点已经搜索
    //出了包含了这个数值的全部结果，同一层的其它结点，候选数的个数更少，搜索出的结果一定不会比第1个结点
    // 更多，并且是第1个结点的子集。
    public static void backTrack(int[] candidates , int target , int index){
        if(target == 0){
            list.add(new ArrayList<>(res)) ;
            return ;
        }
        if(target < 0) return ;
        for(int i = index ; i < candidates.length ; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue ;
            }
            if(candidates[i] > target){
                break ;
            }
            res.add(candidates[i]) ;
            backTrack(candidates , target - candidates[i] , i + 1) ;
            res.remove(res.size() - 1) ;
        }
    }
}
