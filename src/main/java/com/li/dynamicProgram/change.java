package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/05/04/20:55
 * @Description:leetcode T518 题目：518. 零钱兑换 II
给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。请你计算并返回可以凑成总金额
的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。假设每一种面额的硬币有无限个。 
题目数据保证结果符合 32 位带符号整数。
示例 1：
    输入：amount = 5, coins = [1, 2, 5]
    输出：4
    解释：有四种方式可以凑成总金额：
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1
示例 2：
    输入：amount = 3, coins = [2]
    输出：0
    解释：只用面额 2 的硬币不能凑成总金额 3

 */
public class change {
    /*如果求组合数就是外层for循环遍历物品，内层for遍历背包。
      如果求排列数就是外层for遍历背包，内层for循环遍历物品。*/
    public static void main(String[] args) {
        int[] coins = {1,2,5} ;
        int change = change(5, coins);
        System.out.println(change);
    }
    //动态规划思路：这是⼀道典型的背包问题，⼀看到钱币数量不限，就知道这是⼀个完全背包。
    // 但本题和纯完全背包不⼀样，纯完全背包是能否凑成总⾦额，⽽本题是要求凑成总⾦额的个数！
    // 注意题⽬描述中是凑成总⾦额的硬币组合数，为什么强调是组合数呢？组合不强调元素之间的顺序，排列强调元素之间的顺序。
    //1. 确定dp数组以及下标的含义：dp[j]：凑成总⾦额j的货币组合数为dp[j]。
    //2. 确定递推公式：dp[j] （考虑coins[i]的组合总和） 就是所有的dp[j - coins[i]]（不考虑coins[i]）
    //   相加。所以递推公式：dp[j] += dp[j - coins[i]];
    //3. dp数组如何初始化：⾸先dp[0]⼀定要为1，dp[0] = 1是 递归公式的基础。从dp[i]的含义上来讲就是，
    //   凑成总⾦额0的货币组合数为1。下标⾮0的dp[j]初始化为0，这样累计加dp[j - coins[i]]的时候才不会影响真正的dp[j]
    //4. 确定遍历顺序：
    //   因为纯完全背包求得是能否凑成总和，和凑成总和的元素有没有顺序没关系，即：有顺序也⾏，没有顺序也⾏！
    //   ⽽本题要求凑成总和的组合数，元素之间要求没有顺序。所以纯完全背包是能凑成总结就⾏，不⽤管怎么凑的。
    //   本题是求凑出来的⽅案个数，且每个⽅案个数是为组合数。那么本题，两个for循环的先后顺序可就有说法了。
    //   我们先来看 外层for循环遍历物品（钱币），内层for遍历背包（⾦钱总额）的情况。
    public static int change(int amount, int[] coins) {
        int maxCoins = 0 ;
        for(int num : coins){
            if(num > maxCoins){
                maxCoins = num ;
            }
        }
        int maxNum = maxCoins * coins.length ;
        if(maxNum < amount) return 0 ;
        int[] dp = new int[amount + 1] ;
        dp[0] = 1 ;
        for(int i = 0 ; i < coins.length ; i++){
            for(int j = coins[i] ; j <= amount ; j++){
                dp[j] += dp[j - coins[i]] ;
            }
        }
        return dp[amount] ;
    }
}
