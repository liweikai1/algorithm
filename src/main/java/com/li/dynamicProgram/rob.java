package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/09/17:28
 * @Description:leetcode T198 题目：打家劫舍
 题目描述：
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的
防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
示例 1：
    输入：[1,2,3,1]
    输出：4
    解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：
    输入：[2,7,9,3,1]
    输出：12
    解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class rob {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5} ;
        int rob = rob(nums);
        System.out.println(rob);
    }
    //动态规划思路：
    //1. 确定dp数组以及下标的含义：dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的⾦额为dp[i]。
    //2. 确定递推公式：决定dp[i]的因素就是第i房间偷还是不偷。
    //   如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i] ，即：第i-1房⼀定是不考虑的，找出
    //      下标i-2（包括i-2）以内的房屋，最多可以偷窃的⾦额为dp[i-2] 加上第i房间偷到的钱。
    //   如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，（注意这⾥是考虑，并不是⼀定要偷i-1房，
    //      所以不加nums[i-1]）
    //   然后dp[i]取最⼤值，即dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
    //3. dp数组如何初始化：从递推公式dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);可以看出，
    //   递推公式的基础就是dp[0] 和 dp[1]。从dp[i]的定义上来讲，dp[0] ⼀定是 nums[0]，
    //   dp[1]就是nums[0]和nums[1]的最⼤值即：dp[1] =max(nums[0], nums[1])
    //4. 确定遍历顺序：dp[i] 是根据dp[i - 2] 和 dp[i - 1] 推导出来的，那么⼀定是从前到后遍历
    //5. 举例推导dp数组
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length] ;
        dp[0] = nums[0] ;
        dp[1] = Math.max(nums[0] , nums[1]) ;
        for(int i=2 ; i< nums.length ; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2]+nums[i]) ;
        }
        return dp[nums.length-1] ;
    }
}
