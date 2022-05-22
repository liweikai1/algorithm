package com.li.greedy;


/**
 * @Author: li wei kai
 * @Date: 2022/05/21/15:57
 * @Description:leetcode T714 题目：买卖股票的最佳时机含手续费
 题目描述：
给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就
不能再继续购买股票了。返回获得利润的最大值。
注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1：
    输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
    输出：8
    解释：能够达到的最大利润:
        在此处买入 prices[0] = 1
        在此处卖出 prices[3] = 8
        在此处买入 prices[4] = 4
        在此处卖出 prices[5] = 9
        总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
示例 2：
    输入：prices = [1,3,7,5,10,3], fee = 3
    输出：6
 */
public class bestTimeToBuyAndSellStockWithTransactionFee {
//贪心算法：当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利
    public static void main(String[] args) {
        int[] prices = {9,8,7,1,2} ;
        int maxProfit = maxProfit(prices, 3) ;
        System.out.println(maxProfit) ;
    }
    //贪心策略分三种情况：
    // 情况⼀：收获利润的这⼀天并不是收获利润区间⾥的最后⼀天（不是真正的卖出，相当于持有股票），
    // 所以后⾯要继续收获利润。
    // 情况⼆：前⼀天是收获利润区间⾥的最后⼀天（相当于真正的卖出了），今天要重新记录最⼩价格了。
    // 情况三：不作操作，保持原有状态（买⼊，卖出，不买不卖）
    public static int maxProfit(int[] prices, int fee) {
        int sum = 0 ;
        int minPrices = prices[0] + fee ;  // 记录最低价格
        for (int i = 1 ; i < prices.length ; i++){
            // 情况⼆：相当于买⼊
            if (prices[i] + fee < minPrices){
                minPrices = prices[i] + fee ;
            // 计算利润，可能有多次计算利润，最后⼀次计算利润才是真正意义的卖出
            }else if (prices[i] > minPrices){
                sum += prices[i] - minPrices ;
                // 情况⼀，这⼀步很关键
                minPrices = prices[i] ;
            }
        }
        return sum ;
    }
}
