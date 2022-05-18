package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/05/09/20:30
 * @Description:leetcode T213 题目：打家劫舍II
 题目描述：
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋
和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
示例 1：
    输入：nums = [2,3,2]
    输出：3
    解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：
    输入：nums = [1,2,3,1]
    输出：4
    解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：
    输入：nums = [1,2,3]
    输出：3
 */
public class robII {
    public static void main(String[] args) {
        int[] nums = {1,2,3} ;
        int rob = rob(nums);
        System.out.println(rob);
    }
    //动态规划思路：这道题⽬和198.打家劫舍是差不多的，唯⼀区别就是成环了。
    //对于⼀个数组，成环的话主要有如下三种情况：nums = [1,2,3,4,1]
    //1.情况⼀：考虑不包含⾸尾元素 num = [2,3,4]
    //2.情况⼆：考虑包含⾸元素，不包含尾元素 num = [1,2,3,4]
    //3.情况三：考虑包含尾元素，不包含⾸元素 num = [2,3,4,1]
    //⽽情况⼆ 和 情况三 都包含了情况⼀了，所以只考虑情况⼆和情况三就可以了。
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0 ;
        }
        if(nums.length == 1){
            return nums[0] ;
        }
        int start = dp(0 , nums , nums.length-1) ;
        int end = dp(1 , nums , nums.length) ;
        return Math.max(start , end) ;

    }
    public static int dp(int index , int[] nums , int end){
        int[] dp = new int[nums.length] ;
        dp[index] = nums[index] ;
        dp[index+1] = Math.max(nums[index] , nums[index + 1]) ;
        for(int i = index+2 ; i < end ; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2]+nums[i]) ;
        }
        return dp[end-1] ;
    }
}
