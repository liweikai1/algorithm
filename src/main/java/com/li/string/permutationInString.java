package com.li.string;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/31/19:23
 * @Description:leetcode T567 题目：字符串的排列
 题目描述：
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

示例 1：
    输入：s1 = "ab" s2 = "eidbaooo"
    输出：true
    解释：s2 包含 s1 的排列之一 ("ba").
示例 2：
    输入：s1= "ab" s2 = "eidboaoo"
    输出：false
 */
public class permutationInString {
    //滑动窗口，或者双指针
    public static void main(String[] args) {
        String s1 = "ab" ;
        String s2 = "errtbaoo" ;
        boolean checkInclusion = checkInclusion(s1, s2);
        boolean checkInclusion1 = checkInclusion1(s1, s2);
        System.out.println(checkInclusion1);
    }
    //滑动窗口解法：
    //1.由于变位词不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另
    // 一个字符串的变位词。
    //根据这一性质，记 s1 的长度为 n，我们可以遍历 s2 中的每个长度为 n 的子串，判断子串和 s1中每个字符的个数
    // 是否相等，若相等则说明该子串是 s1的一个变位词。
    //2.使用两个数组 arr1、arr2 ，arr1统计s1中的各个字符的个数；arr2统计当前遍历的字串中各个字符的个数
    //3.由于需要遍历的子串长度均为 n，我们可以使用一个固定长度为 n 的滑动窗口来维护 arr2 ：滑动窗口每向右滑动一
    //  次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符。然后，判断 arr1 和 arr2 是否相等，若相等则
    //  意味着 s1 的变位词之一是 s2 的子串。
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length() , m = s2.length() ;
        if (n > m) return false ;
        int[] arr1 = new int[26] ;
        int[] arr2 = new int[26] ;
        for (int i = 0 ; i < n ; i++){
            arr1[s1.charAt(i) - 'a']++ ;
            arr2[s2.charAt(i) - 'a']++ ;
        }
        if (Arrays.equals(arr1 , arr2)) return true ;
        for (int i = n ; i < m ; i++){
            arr2[s2.charAt(i) - 'a']++ ;
            arr2[s2.charAt(i-n) - 'a']-- ;
            if (Arrays.equals(arr1 , arr2))  return true ;
        }
        return false ;
    }
    //双指针法：
    //1.初始时，仅统计 s1 中的字符，则 arr 的值均不为正，且元素值之和为 -n。
    //2.然后用两个指针 left 和 right 表示考察的区间 [left,right]。right 每向右移动一次，就统计一次进入
    //  区间的字符 x。为保证 arr 的值不为正，若此时 arr[x]>0，则向右移动左指针，减少离开区间的字符的
    //  arr 值直到 arr[x]≤0。
    //3.注意到 [left,right] 的长度每增加 1，arr 的元素值之和就增加 1。当 [left,right] 的长度恰好为 n 时，
    //  就意味着 arr 的元素值之和为 0。由于 arr 的值不为正，元素值之和为 0 就意味着所有元素均为 0，这样我们
    //  就找到了一个目标子串。
    public static boolean checkInclusion1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n)  return true;
        }
        return false;
    }
}
