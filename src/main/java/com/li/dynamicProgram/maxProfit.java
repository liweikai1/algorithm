package com.li.dynamicProgram;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/11/15:40
 * @Description:leetcode T123 题目：买卖股票的最佳时机III
 题目描述：
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。设计一个算法来计算你所能获取的最大利润。
你最多可以完成 两笔 交易。 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
    输入：prices = [3,3,5,0,0,3,1,4]
    输出：6
    解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
        随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2：
    输入：prices = [1,2,3,4,5]
    输出：4
    解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
        注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
        因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 */
public class maxProfit {
    //动态规划思路：遇到状态限制的问题，可以将每一种状态都单独列出来
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4} ;
        int maxProfit = maxProfit(prices);
    }
    //1. 确定dp数组以及下标的含义：dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，
    //   dp[i][j]表示第i天状态j所剩最⼤现⾦。
    //   ⼀天⼀共就有五个状态:0 没有操作，1 第⼀次买⼊，2 第⼀次卖出，3 第⼆次买⼊，4 第⼆次卖出
    //2. 确定递推公式：需要注意 dp[i][1]，表示的是第i天，买⼊股票的状态，并不是说⼀定要第i天买⼊股票
    //   达到dp[i][1]状态，有两个具体操作：
    //     操作⼀：第i天买⼊股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
    //     操作⼆：第i天没有操作，⽽是沿⽤前⼀天买⼊的状态，即：dp[i][1] = dp[i - 1][1]
    //   同理dp[i][2]也有两个操作：
    //     操作⼀：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
    //     操作⼆：第i天没有操作，沿⽤前⼀天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
    //   所以dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])
    //   同理可推出剩下状态部分：
    //   dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
    //   dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
    //3. dp数组如何初始化：第0天没有操作即 dp[0][0] = 0;
    //   第0天做第⼀次买⼊的操作，dp[0][1] = -prices[0];
    //   第0天做第⼀次卖出的操作，⾸先卖出的操作⼀定是收获利润，整个股票买卖最差情况也就是没有盈利即
    //     全程⽆操作现⾦为0，从递推公式中可以看出每次是取最⼤值，那么既然是收获利润如果⽐0还⼩了就没
    //     有必要收获这个利润了。所以dp[0][2] = 0;
    //   第0天第⼆次买⼊操作，不⽤管第⼏次，现在⼿头上没有现⾦，只要买⼊，现⾦就做相应的减少。
    //     所以第⼆次买⼊操作，初始化为：dp[0][3] = -prices[0];
    //   同理第⼆次卖出初始化dp[0][4] = 0;
    //4. 确定遍历顺序：从递归公式其实已经可以看出，⼀定是从前向后遍历，因为dp[i]，依靠dp[i - 1]的数值。
    //5. 举例推导dp数组
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0 ;
        int[][] dp = new int[prices.length][5] ;
        dp[0][1] = -prices[0] ;
        dp[0][3] = -prices[0] ;
        for(int i = 1 ; i < prices.length ; i++){
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] - prices[i]) ;
            dp[i][2] = Math.max(dp[i-1][2] , dp[i-1][1] + prices[i]) ;
            dp[i][3] = Math.max(dp[i-1][3] , dp[i-1][2] - prices[i]) ;
            dp[i][4] = Math.max(dp[i-1][4] , dp[i-1][3] + prices[i]) ;
            for (int[] num : dp){
                System.out.println(Arrays.toString(num));
            }
            System.out.println("----------这是分割线------------");
        }
        return dp[prices.length - 1][4] ;
    }
}
