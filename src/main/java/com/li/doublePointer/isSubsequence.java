package com.li.doublePointer;

/**
 * @Author: li wei kai
 * @Date: 2022/05/12/21:11
 * @Description:leetcode T392 题目：判断子序列
 题目描述：
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（
例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1：
    输入：s = "abc", t = "ahbgdc"
    输出：true
示例 2：
    输入：s = "axc", t = "ahbgdc"
    输出：false

进阶：
如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的
子序列。在这种情况下，你会怎样改变代码？

 */
public class isSubsequence {
    //双指针法：
    public static void main(String[] args) {
        String s = "abc" ;
        String t = "adhfbohuasuc" ;
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }
    //本题询问的是，s是否是t的子序列，因此只要能找到任意一种s在t中出现的方式，即可认为s是t的子序列。
    // 而当我们从前往后匹配，可以发现每次贪心地匹配靠前的字符是最优决策。
    //这样，我们初始化两个指针 i 和 j，分别指向 s 和 t 的初始位置。每次贪心地匹配，匹配成功则 i和 j
    // 同时右移，匹配 s 的下一个位置，匹配失败则 j 右移，i 不变，尝试用 t 的下一个字符匹配 s。
    // 最终如果 i 移动到 s 的末尾，就说明 s 是 t 的子序列。
    public static boolean isSubsequence(String s, String t) {
        int n = s.length() ;
        int m = t.length() ;
        int l = 0 , r = 0 ;
        while(l < n && r < m){
            if(s.charAt(l) == t.charAt(r)){
                l++ ;
            }
            r++ ;
        }
        return l == n ;
    }
}
