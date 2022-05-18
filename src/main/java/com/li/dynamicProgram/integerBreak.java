package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/02/20:35
 * @Description:leetcode T343 题目：整数拆分
 题目描述：
给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。
示例 1:
    输入: n = 2
    输出: 1
    解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:
    输入: n = 10
    输出: 36
    解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class integerBreak {
    public static void main(String[] args) {
        int n = 10 ;
        int integerBreak = integerBreak(8);
        System.out.println(integerBreak);
    }
    ///动态规划思路：01背包问题
    //1. 确定dp数组以及下标的含义： dp[i]，分拆数字i，可以得到的最⼤乘积为dp[i]
    //2. 确定递推公式： 可以想dp[i]最⼤乘积是怎么得到的呢？其实可以从1遍历到j，然后有两种渠道得到dp[i].
    //⼀个是j * (i - j) 直接相乘。⼀个是j * dp[i - j]，相当于是拆分(i - j)，对这个拆分不理解的话，可以回想dp数组的定义。
    //j为什么不拆分呢？因为j是从1开始遍历，拆分j的情况，在遍历j的过程中其实都计算过了。从1遍历j，⽐较(i-j) * j和
    //dp[i-j] * j 取最⼤的。递推公式就可得到：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j))
    //3. dp的初始化：严格从dp[i]的定义来说，dp[0] dp[1] 就不应该初始化，也就是没有意义的数值。
    //拆分0和拆分1的最⼤乘积是多少？这是⽆解的。
    //这⾥只初始化dp[2] = 1，从dp[i]的定义来说，拆分数字2，得到的最⼤乘积是1，这个没有任何异议！
    //4. 确定遍历顺序：确定遍历顺序，先来看看递归公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
    //dp[i] 是依靠 dp[i - j]的状态，所以遍历i⼀定是从前向后遍历，先有dp[i - j]再有dp[i]。
    //枚举j的时候，是从1开始的。i是从3开始，这样dp[i - j]就是dp[2]正好可以通过我们初始化的数值求出来。
    //5. 举例推导dp数组：手动推导
    public static int integerBreak(int n) {
        int[] dp = new int[n+1] ;
        dp[2] = 1 ;
        for (int i = 3 ; i <= n ; i++){
            for(int j = 1 ; j < i - 1 ; j++){
                dp[i] =Math.max(dp[i] , Math.max(j*(i-j) , j*dp[i-j])) ;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n] ;
    }
}
