package com.li.string;

/**
 * @Author: li wei kai
 * @Date: 2022/04/19/17:11
 * @Description:题目： 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。
示例 1：
    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：
    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0
 */
public class minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {1,1,1} ;
        int target = 4 ;
        int minSubArrayLen = minSubArrayLen(target, nums);
        System.out.println("最小的子数组长度为：" + minSubArrayLen);

    }
     //滑动窗口解题思路：
//   1.定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，
//     维护变量 sum 存储子数组中的元素和（即从 nums[start] 到 nums[end] 的元素和）。
//   2.初始状态下，start 和 end 都指向下标 0，sum 的值为 0。
//   3.每一轮迭代，将nums[end] 加到 sum，如果 sum≥target，则更新子数组的最小长度
//   （此时子数组的长度是 end−start+1），然后将 nums[start] 从 sum 中减去
//    并将 start 右移，直到 sum<target，在此过程中同样更新子数组的最小长度。
//    在每一轮迭代的最后，将 end 右移
//
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length ;
        int start = 0 ;
        int end = 0 ;
        int ans = Integer.MAX_VALUE ;
        int sum = 0 ;
        while(end < n){
            sum += nums[end] ;
            while(sum >= target){
                ans = Math.min(ans , end - start + 1) ;
                sum -= nums[start] ;
                start += 1 ;
            }
            end += 1 ;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans ;
    }
}
