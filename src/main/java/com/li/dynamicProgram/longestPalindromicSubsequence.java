package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/16/17:04
 * @Description:leetcode T516 题目：最长回文子序列
 题目描述：
给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

示例 1：
    输入：s = "bbbab"
    输出：4
    解释：一个可能的最长回文子序列为 "bbbb" 。
示例 2：
    输入：s = "cbbd"
    输出：2
    解释：一个可能的最长回文子序列为 "bb" 。

 */
public class longestPalindromicSubsequence {
    //动态规划
    public static void main(String[] args) {
        String s = " vvvbvc" ;
        int longestPalindromeSubseq = longestPalindromeSubseq(s);
        System.out.println(longestPalindromeSubseq);
    }
    //1. 确定dp数组以及下标的含义,dp[i][j]：字符串s在[i, j]范围内最⻓的回⽂⼦序列的⻓度为dp[i][j]。
    //2. 确定递推公式：分如下两种情况讨论。
    //   如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
    //   如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加⼊ 并不能增加[i,j]区间回⽂⼦串的⻓度，
    //      那么分别加⼊s[i]、s[j]看看哪⼀个可以组成最⻓的回⽂⼦序列。
    //      dp[i][j]⼀定是取最⼤的，即：dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
    //3. dp数组如何初始化：⾸先要考虑当i 和j 相同的情况，从递推公式：dp[i][j] = dp[i + 1][j - 1] + 2;
    //   可以看出递推公式是计算不到 i 和j相同时候的情况。所以需要⼿动初始化⼀下，
    //   当i与j相同，那么dp[i][j]⼀定是等于1的，即：⼀个字符的回⽂⼦序列⻓度就是1。
    //   其他情况dp[i][j]初始为0就⾏。
    //4. 确定遍历顺序：从递推公式dp[i][j] = dp[i + 1][j - 1] + 2 和 dp[i][j] =
    //   max(dp[i + 1][j], dp[i][j - 1]) 可以看出，dp[i][j]是依赖于dp[i+1][j-1]
    //   和 dp[i + 1][j]，也就是从矩阵的⻆度来说，dp[i][j] 下⼀⾏的数据。 所以遍历i的时候
    //   ⼀定要从下到上遍历，这样才能保证，下⼀⾏的数据是经过计算的。
    //5. 举例推导dp数组
    public static int longestPalindromeSubseq(String s) {
        int len = s.length() ;
        int[][] dp = new int[len][len] ;
        for (int i = 0 ; i < len ; i++){
            dp[i][i] = 1 ;
        }
        for (int i = len-1 ; i >= 0 ; i--){
            for (int j = i + 1 ; j < len ; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2 ;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]) ;
                }
                for (int[] num : dp){
                    System.out.println(Arrays.toString(num));
                }
                System.out.println("--------这是分割线-----------");
            }
        }
        return dp[0][len-1] ;
    }
}
