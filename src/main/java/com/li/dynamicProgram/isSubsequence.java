package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/12/21:41
 * @Description:leetcode T392 题目：判断子序列
 *  题目描述：
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（
 * 例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1：
 *     输入：s = "abc", t = "ahbgdc"
 *     输出：true
 * 示例 2：
 *     输入：s = "axc", t = "ahbgdc"
 *     输出：false
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的
 * 子序列。在这种情况下，你会怎样改变代码？
 */
public class isSubsequence {
    //动态规划
    public static void main(String[] args) {
        String s = "axc" ;
        String t = "adbouac" ;
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }
    //1. 确定dp数组以及下标的含义：dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，
    //   相同⼦序列的⻓度为dp[i][j]。注意这⾥是判断s是否为t的⼦序列。即t的⻓度是⼤于等于s的。
    //2. 确定递推公式：在确定递推公式的时候，⾸先要考虑如下两种操作，整理如下：
    //   if (s[i - 1] == t[j - 1]): t中找到了⼀个字符在s中也出现了
    //   if (s[i - 1] != t[j - 1]): 相当于t要删除元素，继续匹配
    //   if (s[i - 1] == t[j - 1])，那么dp[i][j] = dp[i - 1][j - 1] + 1;
    //   因为找到了⼀个相同的字符，相同⼦序列⻓度⾃然要在dp[i-1][j-1]的基础上加1。
    //   if (s[i - 1] != t[j - 1])，此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，那么
    //   dp[i][j] 的数值就是看s[i-1] 与 t[j-2]的⽐较结果了，即：dp[i][j] = dp[i][j - 1];
    //3. dp数组如何初始化：从递推公式可以看出dp[i][j]都是依赖于dp[i - 1][j - 1] 和 dp[i][j - 1]，
    //   所以dp[0][0]和dp[i][0]是⼀定要初始化的。
    //   这⾥dp[i][0]和dp[0][j]是没有含义的，仅仅是为了给递推公式做前期铺垫，所以初始化为0。
    //4. 确定遍历顺序：同理从从递推公式可以看出dp[i][j]都是依赖于dp[i - 1][j - 1] 和 dp[i][j - 1]，
    //   那么遍历顺序也应该是从上到下，从左到右。
    //5. 举例推导dp数组
    public static boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1] ;
        for(int i = 1 ; i <= s.length() ; i++){
            for(int j = 1 ; j <= t.length() ; j++){
                // if (s[i - 1] == t[j - 1]): t中找到了⼀个字符在s中也出现了
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                // if (s[i - 1] != t[j - 1]): 相当于t要删除当前元素，则动态规划状态和前一个一样即：
                // dp[i][j] = dp[i][j-1]，继续匹配  。
                }else{
                    dp[i][j] = dp[i][j-1] ;
                }
                for (int[] d : dp){
                    System.out.println(Arrays.toString(d));
                }
                System.out.println("----------这是分割线-----------");
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
