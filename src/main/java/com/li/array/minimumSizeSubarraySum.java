package com.li.array;

/**
 * @Author: li wei kai
 * @Date: 2022/05/27/20:56
 * @Description:leetcode T209 题目：长度最小的子数组
 题目描述：
给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 
[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

示例 1：
    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：
    输入：target = 4, nums = [1,4,4]
    输出：1
示例 3：
    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0
 */
public class minimumSizeSubarraySum {
    //解题思路：滑动窗口
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3} ;
        int minSubArrayLen = minSubArrayLen(7, nums);
        System.out.println(minSubArrayLen);
    }
    //解题步骤：
    //1.定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，维护变量 sum 存储子数组中的
    // 元素和（即从 nums[start] 到 nums[end] 的元素和）。
    //2.初始状态下，start 和 end 都指向下标 0，sum 的值为 0。
    //3.每一轮迭代，将 nums[end] 加到 sum，如果 sum ≥ s，则更新子数组的最小长度（此时子数组的长度是end−start+1），
    // 然后将 nums[start] 从 sum 中减去并将 start 右移，直到 sum < s，在此过程中同样更新子数组的最小长度。
    // 在每一轮迭代的最后，将 end 右移。
    public static int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE ;
        int start = 0 , end = 0 ;
        int sum = 0 ;
        while (end < nums.length){
            sum += nums[end] ;
            while (sum >= target){
                len = Math.min(len , end - start + 1) ;
                sum -= nums[start] ;
                start++ ;
            }
            end++ ;
        }
        return len == Integer.MAX_VALUE ? 0 : len ;
    }
}
