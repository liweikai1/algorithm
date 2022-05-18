package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/13/20:49
 * @Description:leetcode T583 题目：两个字符串的删除操作
 题目描述：
给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
每步 可以删除任意一个字符串中的一个字符。

示例 1：
    输入: word1 = "sea", word2 = "eat"
    输出: 2
    解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
示例  2:
    输入：word1 = "leetcode", word2 = "etco"
    输出：4
 */
public class deleteOperationForTwoStrings {
    //动态规划
    public static void main(String[] args) {
        String word1 = "park" ;
        String word2 = "spake" ;
        int minDistance = minDistance(word1, word2);
        System.out.println(minDistance);
    }
    //1. 确定dp数组以及下标的含义：dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串
    //   word2，想要达到相等，所需要删除元素的最少次数。
    //2. 确定递推公式：分为两种情况
    //   1）当word1[i - 1] 与 word2[j - 1]相同的时候
    //      即：dp[i][j] = dp[i - 1][j - 1];
    //   2）当word1[i - 1] 与 word2[j - 1]不相同的时候，有以下情况：
    //      情况⼀：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
    //      情况⼆：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
    //     最后取最⼩值，所以当word1[i - 1] 与 word2[j - 1]不相同的时候，递推公式
    //     即：dp[i][j] =min(dp[i - 1][j] , dp[i][j - 1]) + 1;
    //3. dp数组如何初始化：从递推公式中，可以看出来，dp[i][0] 和 dp[0][j]是⼀定要初始化的。
    //   dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同？
    //   很明显dp[i][0] = i。同理dp[0][j] = j ;
    //4. 确定遍历顺序：双重for循环，从 i = 1 、j = 1 开始遍历。
    //5. 举例推导dp数组
    public static int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length() ;
        int[][] dp = new int[n+1][m+1] ;
        for (int i = 1 ; i <= n ; i++){
            dp[i][0] = i ;
        }
        for (int j = 1 ; j <= m ; j++){
            dp[0][j] = j ;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] ;
                }else {
                    dp[i][j] = Math.min(dp[i][j-1] , dp[i-1][j]) + 1 ;
                }
                for (int[] d : dp){
                    System.out.println(Arrays.toString(d));
                }
                System.out.println("----------这是分割线-----------");
            }
        }
        return dp[n][m] ;
    }
}
