package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/04/06/20:41
 * @Description: LeetCode T53 题目 ；连续子数组的最大和
题目描述:输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。

示例1:
    输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组[4,-1,2,1]的和最大，为 6。
 */
public class maxSubArray {
    //动态规划思路：
//    状态定义：设动态规划列表 dp ，dp[i]代表以元素 nums[i] 结尾的连续子数组最大和。
//          为何定义最大和 dp[i]中必须包含元素 nums[i]：保证 dp[i]递推到 dp[i+1]的正确性；如果不包含 nums[i]，递推时则不满足题目的连续子数组要求。
//    转移方程：若dp[i−1]≤0 ，说明 dp[i-1]对 dp[i]产生负贡献，即 dp[i-1] + nums[i]还不如 nums[i]本身大。
//          当 dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]；
//          当 dp[i−1]≤0 时：执行 dp[i] = nums[i] ；
//    初始状态： dp[0] = nums[0]，即以 nums[0] 结尾的连续子数组最大和为 nums[0] 。
//    返回值： 返回 dp 列表中的最大值，代表全局最大值。

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;

        int max = nums[0] ;
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        System.out.println("连续子数组的最大和为：" + max);
    }
}
