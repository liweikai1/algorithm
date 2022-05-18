package com.li.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/23/19:26
 * @Description:leetcode T46 题目：全排列
 题目描述：
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：

    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class permute {
    //设置成全局变量，这样在进行递归的时候就不需要传参了
    private static final List<List<Integer>> list = new ArrayList<>() ;
    private static final List<Integer> res = new ArrayList<>() ;

    public static void main(String[] args) {
        int[] nums = {1,1,3} ;
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);

    }

    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null) return list ;
        //标志数组，用来表示当前数是否被使用(即是否在res数组中)，若已被使用则遍历的时候跳过该数字
        boolean[] visited = new boolean[nums.length] ;
        //因为在下文每次都是从0开始，逐个遍历nums数组，所以这里不需要for循环了
        backTrack(nums , visited) ;
        return list ;
    }
    //采用深度优先搜索的方式遍历
    public static void backTrack(int[] nums , boolean[] visited){
        //递归结束条件，当遍历完整个数组时，长度应该和数组长度相等
        if(res.size() == nums.length){
            //因为一直在维护res集合，所以在添加的时候需要重新构建一个List集合，否则添加之后只有一个集合
            list.add(new ArrayList<>(res)) ;
            return ;
        }
        //循环遍历，每次递归都会从 i=0 开始，因为有visited数组存在会跳过已经遍历过的数字
        for(int i = 0 ; i < nums.length ; i++){
            //visited数组长度对应nums数组，已经访问过的数字会在visited中置为true，visited中true的
            //数量也表示这当前的遍历到第几层。
            if (visited[i]){
               continue;
            }
            //处理节点
            res.add(nums[i]) ;
            visited[i] = true ;
            //递归，进入下一层
            backTrack(nums , visited) ;
            //回退，撤销最近的处理结果，相当于回退至上一层
            visited[i] = false ;
            res.remove(res.size() - 1) ;
        }
    }
}
