package com.li.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/24/20:17
 * @Description:leetcode T46 题目：全排列 II
思考：
为什么造成了重复，如何在搜索之前就判断这一支会产生重复；
 */
public class permuteUnique {
    private static List<List<Integer>> list = new ArrayList<>() ;
    private static List<Integer> res = new ArrayList<>() ;

    public static void main(String[] args) {
        int[] nums = {1,3,1} ;
        List<List<Integer>> permuteUnique = permuteUnique(nums);
        System.out.println(permuteUnique);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return list ;
        boolean[] visited = new boolean[nums.length] ;
    // 排序（升序或者降序都可以），排序是剪枝的前提
        // 为什么要先排序?
        //   因为结果是要去重的，而结果都是列表形式的，那列表怎么判重呢？就是排序之后一个一个的比较，
        //   所以那还不如先排序之后再计算，再计算的过程中判断是否有重复，免得对每个结果再做一次排序去重操作。
        Arrays.sort(nums);
        backTrack(nums , visited);
        return list ;
    }

    public static void backTrack(int[] nums , boolean[] visited){
        if(res.size() == nums.length){
            list.add(new ArrayList<>(res)) ;
            return ;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if (visited[i] ){
                continue ;
            }
         //剪枝条件：该元素与之前的元素是否重复，并且判断前面的元素是否被使用过
            //怎么判断当前分支是否是重复的分支？
            //  因为之前已经排好序了，所以当前元素nums[i]如果和前一个元素相同 ，即nums[i]==nums[i-1]
            //  就说明该分支有可能是重复的。 但是这个相等条件有两种可能：一种是，1 1‘ 2，也就是选择完1之后
            //  再选择第二个1，两个元素虽然重复，但是第二个元素是前一个元素的下一层，这时是没有问题的。 另一种
            //  是之前的 同层 分支已经有 1 1‘ 2了，这次的选择是 1‘ 1 2 。两个元素重复，且重的是同层路径。
            //  那就说明是重复分支。
            //具体区分的办法是 nums[i-1] 的visited状态是被选择的，那么说明当前的nums[i] 是 nums[i-1]
            // 的一层路径。否则如果 nums[i-1] 的状态是没被选择的，那么说明当前 的nums[i] 是nums[i-1]
            // 同层路径。
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
//为什么" nums[i-1] 的used状态是被选择的，那么说明当前的nums[i] 是 nums[i-1]的下一层路径。"
    //原因：因为往下层递归的话，一直再往下层走，dfs还未return，也就是说used还没有被回溯为未选择状态，
    //     所以同一条分支上，nums[i-1] 的used状态一定是被选择的。
//为什么“ 如果 nums[i-1] 的状态是没被选择的，那么说明当前 的nums[i] 是nums[i-1] 同层路径。”
    //原因：递归到叶节点，开始往上回溯了，回溯到某一层时把used[i-1]回溯为未选择状态，
    //     然后for循环i++横向移动，自然这时再判断used[i-1]就一定是未选择状态。
            res.add(nums[i]) ;
            visited[i] = true ;
            backTrack(nums , visited);
            visited[i] = false ;
            res.remove(res.size() - 1) ;
        }
    }
}
