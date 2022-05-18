package com.li.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/25/21:35
 * @Description:leetcode T39 题目：组合总和
 题目描述：
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使
数字和为目标数 target 的所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的同一个数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
对于给定的输入，保证和为 target 的不同组合数少于 150 个。
示例 1：
    输入：candidates = [2,3,6,7], target = 7
    输出：[[2,2,3],[7]]
    解释：
    2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    7 也是一个候选， 7 = 7 。
    仅有这两种组合。
示例 2：
    输入: candidates = [2,3,5], target = 8
    输出: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class combinationSum {
    private static List<List<Integer>> list = new ArrayList<>() ;
    private static List<Integer> res = new ArrayList<>() ;

    public static void main(String[] args) {
        int[] nums = {2,3,6,7} ;
        int target = 7 ;
        List<List<Integer>> combinationSum = combinationSum(nums, target);
        System.out.println(combinationSum);
    }
    //这一类问题都需要先画出树形图，然后编码实现。
    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) return list ;
        Arrays.sort(candidates) ;
        backTrack(candidates , target , 0) ;
        return list ;
    }
    //分析重复路径产生的原因?
    public static void backTrack(int[] candidates , int val , int index){
        if(val == 0){
            list.add(new ArrayList<>(res)) ;
            return ;
        }
        if(val < 0) return ;
        //产生重复的原因是：在每一个结点，做减法，展开分支的时候，由于题目中说 每一个元素可以重复使用，
        // 我们考虑了所有的候选数，因此出现了重复的列表。
        //一种简单的去重方案是借助哈希表的天然去重的功能，但实际操作一下，就会发现并没有那么容易。
        //可不可以在搜索的时候就去重呢？答案是可以的。遇到这一类相同元素不计算顺序的问题，我们在搜索的时
        // 候就需要按某种顺序搜索。具体的做法是：每一次搜索的时候设置下一轮搜索的起点 index
        for(int i = index ; i < candidates.length ; i++){
            if (candidates[i] > val){
                break ;
            }
            res.add(candidates[i]) ;
            System.out.println("递归之前=>" + res +"," + "剩余target值=>" + (val-candidates[i]));
            backTrack(candidates , val-candidates[i] , i) ;
            res.remove(res.size() - 1) ;
            System.out.println("递归之后=>" + res );
        }
    }
}
