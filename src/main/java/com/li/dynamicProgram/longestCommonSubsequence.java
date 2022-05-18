package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/05/13/21:43
 * @Description:leetcode T1143 题目：最长公共子序列
 题目描述：
给定两个字符串text1和text2，返回这两个字符串的最长公共子序列的长度。如果不存在 公共子序列 ，返回 0。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

示例 1：
    输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace" ，它的长度为 3 。
示例 2：
    输入：text1 = "abc", text2 = "def"
    输出：0
    解释：两个字符串没有公共子序列，返回 0 。
 */
public class longestCommonSubsequence {
    //动态规划
    public static void main(String[] args) {
        String text1 = "spake" ;
        String text2 = "park" ;
        int longestCommonSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println(longestCommonSubsequence);
    }
    //1. 确定dp数组以及下标的含义：dp[i][j]：⻓度为[0, i - 1]的字符串text1与⻓度为[0, j - 1]
    //   的字符串text2的最⻓公共⼦序列为dp[i][j]
    //2. 确定递推公式：主要就是两⼤情况：
    // 1)如果text1[i - 1] 与 text2[j - 1]相同，
    //   那么找到了⼀个公共元素，即：dp[i][j] = dp[i - 1][j - 1] + 1;
    // 2)如果text1[i - 1] 与 text2[j - 1]不相同，
    //   那就看text1[0, i - 2]与text2[0, j - 1]的最⻓公共⼦序列和text1[0, i - 1]
    //   与text2[0, j - 2]的最⻓公共⼦序列，取最⼤的。
    //   即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
    //3. dp数组如何初始化：test1[0, i-1]和空串的最⻓公共⼦序列⾃然是0，所以dp[i][0] = 0;
    //   同理dp[0][j]也是0。
    //4. 确定遍历顺序：从递推公式，可以看出，有三个⽅向可以推出dp[i][j]，那么为了在递推的过程中，
    //   这三个⽅向都是经过计算的数值，所以要从前向后，从上到下来遍历这个矩阵。
    //5. 举例推导dp数组
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length() ;
        int[][] dp = new int[n+1][m+1] ;
        for (int i = 1 ; i <= n ; i++){
            for (int j = 1 ; j <= m ; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]) ;
                }
            }
        }
        return dp[n][m] ;
    }
}
