package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/16/11:17
 * @Description:leetcode T647 题目：回文子串
 题目描述；
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
回文字符串 是正着读和倒过来读一样的字符串。子字符串 是字符串中的由连续字符组成的一个序列。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

示例 1：
    输入：s = "abc"
    输出：3
    解释：三个回文子串: "a", "b", "c"
示例 2：
    输入：s = "aaa"
    输出：6
    解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class palindromicSubstrings {
    public static void main(String[] args) {
        String s = "abc" ;
        int countSubstrings = countSubstrings(s);
        System.out.println(countSubstrings);
    }
    //1. 确定dp数组以及下标的含义：布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）
    //   的⼦串是否是回⽂⼦串，如果是dp[i][j]为true，否则为false。
    //2. 确定递推公式：分为如下两种情况 1. s[i]与s[j]相等 2. s[i]与s[j]不相等。
    //   当s[i]与s[j]不相等，，dp[i][j]⼀定是false。
    //   当s[i]与s[j]相等时，有如下三种情况
    //     情况⼀：下标i 与 j相同，同⼀个字符例如a，当然是回⽂⼦串
    //     情况⼆：下标i 与 j相差为1，例如aa，也是回⽂⼦串
    //     情况三：下标i 与 j相差⼤于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i
    //     到j区间是不是回⽂⼦串就看aba是不是回⽂就可以了，那么aba的区间就是 i+1 与 j-1区间，
    //     这个区间是不是回⽂就看dp[i + 1][j - 1]是否为 true。
    //3. dp数组如何初始化：dp[i][j]初始化为false。
    //4. 确定遍历顺序：要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
    //   即：i 倒序遍历， j 正序遍历
    //5. 举例推导dp数组
    public static int countSubstrings(String s) {
        int len = s.length() ;
        int ans = 0 ;
        boolean[][] dp = new boolean[len][len] ;
        for (int i = len - 1 ; i >=0 ; i--){
            char c = s.charAt(i);
            for (int j = i ; j < len ; j++){
                char c1 = s.charAt(j);
                if (c == c1) {
                    if (j-i <= 1){ //情况1，情况2
                        ans++ ;
                        dp[i][j] = true ;
                    }else if (dp[i+1][j-1]){//情况3
                        ans++ ;
                        dp[i][j] = true ;
                    }
                }
                for (boolean[] num : dp){
                    System.out.println(Arrays.toString(num));
                }
                System.out.println("-------------这是分割线-----------");
            }
        }
        return ans ;
    }
}
