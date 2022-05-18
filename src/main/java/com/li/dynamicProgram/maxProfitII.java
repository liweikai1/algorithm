package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/11/20:13
 * @Description:leetcode T309 题目：最佳卖卖股票时机含冷冻期
 题目描述：
给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
    输入: prices = [1,2,3,0,2]
    输出: 3
    解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class maxProfitII {
    //动态规划思路：
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2} ;
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
    //1. 确定dp数组以及下标的含义：dp[i][j]，第i天状态为j，所剩的最多现⾦为dp[i][j]。
    //   具体可以区分出如下四个状态：
    //   状态⼀：买⼊股票状态（今天买⼊股票，或者是之前就买⼊了股票然后没有操作）0：状态⼀
    //   卖出股票状态，这⾥就有两种卖出股票状态
    //   状态⼆：两天前就卖出了股票，度过了冷冻期，⼀直没操作，今天保持卖出股票状态 1：状态⼆
    //   状态三：今天卖出了股票                                       2：状态三
    //   状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有⼀天！           3：状态四
    //2. 确定递推公式：{1,2,3,0,2}
    //   达到买⼊股票状态（状态⼀）即：dp[i][0]，有两个具体操作：
    //     操作⼀：前⼀天就是持有股票状态（状态⼀），dp[i][0] = dp[i - 1][0]
    //     操作⼆：今天买⼊了，有两种情况
    //         前⼀天是冷冻期（状态四），dp[i - 1][3] - prices[i]
    //         前⼀天是保持卖出股票状态（状态⼆），dp[i - 1][1] - prices[i]
    //        所以操作⼆取最⼤值，即：max(dp[i - 1][3], dp[i - 1][1]) - prices[i]
    //     那么dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
    //   达到保持卖出股票状态（状态⼆）即：dp[i][1]，有两个具体操作：
    //     操作⼀：前⼀天就是状态⼆
    //     操作⼆：前⼀天是冷冻期（状态四）
    //    dp[i][1] = max(dp[i - 1][1], dp[i - 1][3]);
    //   达到今天就卖出股票状态（状态三），即：dp[i][2] ，只有⼀个操作：
    //     操作⼀：昨天⼀定是买⼊股票状态（状态⼀），今天卖出
    //    即：dp[i][2] = dp[i - 1][0] + prices[i];
    //   达到冷冻期状态（状态四），即：dp[i][3]，只有⼀个操作：
    //     操作⼀：昨天卖出了股票（状态三）
    //    dp[i][3] = dp[i - 1][2];
    //3. dp数组如何初始化：这⾥主要讨论⼀下第0天如何初始化。
    //   如果是持有股票状态（状态⼀）那么：dp[0][0] = -prices[0]，买⼊股票所剩现⾦为负数。
    //   保持卖出股票状态（状态⼆），第0天没有卖出dp[0][1]初始化为0就⾏，
    //   今天卖出了股票（状态三），同样dp[0][2]初始化为0，因为最少收益就是0，绝不会是负数。
    //   同理dp[0][3]也初始为0。
    //4. 确定遍历顺序：从递归公式上可以看出，dp[i] 依赖于 dp[i-1]，所以是从前向后遍历。
    //5. 举例推导dp数组：最后结果是 状态⼆，状态三，和状态四的最⼤值，状态四是冷冻期，最后
    //   ⼀天如果是冷冻期也可能是最⼤值。
    public static int maxProfit(int[] prices){
        int[][] dp = new int[prices.length][4] ;
        dp[0][0] = -prices[0] ;
        for (int i = 1 ; i < prices.length ; i++){
            //状态一：买入股票
            dp[i][0] = Math.max(dp[i-1][0] , Math.max(dp[i-1][3] , dp[i-1][1]) - prices[i]) ;
            //状态二：两天前就卖出了股票，度过了冷冻期，但是没操作
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][3]) ;
            //状态三：今天卖出去股票
            dp[i][2] = dp[i-1][0] + prices[i] ;
            //状态四：今天是冷冻期
            dp[i][3] = dp[i-1][2] ;
            for (int[] num : dp){
                System.out.println(Arrays.toString(num));
            }
            System.out.println("---------这是分割线------------");
        }
        return Math.max(dp[prices.length-1][1] , Math.max(dp[prices.length-1][2] , dp[prices.length-1][3])) ;
    }
}
