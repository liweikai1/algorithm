package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/12/14:33
 * @Description:leetcode T300 题目 最长递增子序列
 题目描述：
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
    输入：nums = [0,1,0,3,2,3]
    输出：4
示例 3：
    输入：nums = [7,7,7,7,7,7,7]
    输出：1
 */
public class longestIncreasingSubsequence {
    //动态规划思路：
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6} ;
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
    //1. dp[i]的定义：dp[i]表示i之前包括i的最⻓上升⼦序列。
    //2. 状态转移⽅程：位置i的最⻓升序⼦序列等于j从 0 到 i-1 各个位置的最⻓升序⼦序列 + 1 的最⼤值。
    //   所以：if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
    //   注意这⾥不是要dp[i] 与 dp[j] + 1进⾏⽐较，⽽是我们要取dp[j] + 1的最⼤值。
    //3. dp[i]的初始化：每⼀个i，对应的dp[i]（即最⻓上升⼦序列）起始⼤⼩⾄少都是是1.
    //4. 确定遍历顺序：dp[i]是有0到i-1各个位置的最⻓升序⼦序列 推导⽽来，那么遍历i⼀定是从前向后遍历。
    //   j其实就是 0 到 i-1 ，遍历 i 的循环⾥外层，遍历 j 则在内层
    //5. 举例推导dp数组
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length] ;
        Arrays.fill(dp , 1) ;
        int maxNum = 0 ;
        for (int i = 1 ; i < nums.length ; i++){
            for (int j = 0 ; j < i ; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , dp[j]+1) ;
                }
            }
            // 取⻓的⼦序列
            if (dp[i] > maxNum) maxNum = dp[i] ;
        }
        return maxNum ;
    }
}
