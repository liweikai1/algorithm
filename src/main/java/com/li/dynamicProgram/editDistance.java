package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/15/20:08
 * @Description:leetcode T72 题目：编辑距离
 题目描述：
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：1.插入一个字符 2.删除一个字符 3.替换一个字符
 
示例 1：

    输入：word1 = "horse", word2 = "ros"
    输出：3
    解释：horse -> rorse (将 'h' 替换为 'r') ，rorse -> rose (删除 'r') ，rose -> ros (删除 'e')
 */
public class editDistance {
    public static void main(String[] args) {
        String word1 = "park" ;
        String word2 = "speak" ;
        int minDistance = minDistance(word1, word2);
        System.out.println(minDistance);

    }
    //1. 确定dp数组以及下标的含义：dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为
    //   结尾的字符串word2，最近编辑距离为dp[i][j]。
    //2. 确定递推公式：在确定递推公式的时候，⾸先要考虑清楚编辑的⼏种操作，整理如下：
    //   1）if (word1[i - 1] == word2[j - 1]) ；不操作
    //   2）if (word1[i - 1] != word2[j - 1]) ；1.增 2.删 3.换
    //   也就是如上4种情况。
    //  if (word1[i - 1] == word2[j - 1]) 那么说明不⽤任何编辑， dp[i][j]就应该是dp[i-1]
    //    [j-1] ，即 dp[i][j] = dp[i - 1][j - 1];
    //  if (word1[i - 1] != word2[j - 1]) ，此时就需要编辑了，如何编辑呢？
    //    操作⼀：word1删除⼀个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的
    //      最近编辑距离 再加上⼀个操作。即 dp[i][j] = dp[i - 1][j] + 1;
    //    操作⼆：word2删除⼀个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的
    //      最近编辑距离 再加上⼀个操作。即 dp[i][j] = dp[i][j - 1] + 1;
    //    操作三：替换元素， word1 替换 word1[i - 1] ，使其与 word2[j - 1] 相同，此时不⽤
    //      增加元素，那么以下标 i-2 为结尾的 word1 与 j-2 为结尾的 word2 的最近编辑距离
    //      加上⼀个替换元素的操作。即 dp[i][j] = dp[i - 1][j - 1] + 1;
    //    综上，当 if (word1[i - 1] != word2[j - 1]) 时取最⼩的，
    //    即：dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]))+1;
    //3. dp数组如何初始化：dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符
    //   串word2，最近编辑距离为dp[i][j]。那么dp[i][0] 和 dp[0][j] 表示什么呢？
    //   dp[i][0] ：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]。
    //     那么dp[i][0]就应该是i，对word1⾥的元素全部做删除操作，即：dp[i][0] = i;
    //   同理dp[0][j] = j
    //4. 确定遍历顺序：双重for循环，从 1 开始遍历
    //5. 举例推导dp数组
    public static int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length() ;
        int[][] dp = new int[n+1][m+1] ;
        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = i ;
        }
        for(int j = 0 ; j <= m ; j++){
            dp[0][j] = j ;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] ;
                }else{
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1 ;
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
