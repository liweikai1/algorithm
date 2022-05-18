package com.li.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/30/22:06
 * @Description:leetcode T131 题目：分割回文串
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。

示例 1：
    输入：s = "aab"
    输出：[["a","a","b"],["aa","b"]]
示例 2：
    输入：s = "a"
    输出：[["a"]]
 */
public class partition {
    private static List<List<String>> list = new ArrayList<>() ;
    private static List<String> res = new ArrayList<>() ;

    public static void main(String[] args) {
        String s = "aba" ;
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }

    public static List<List<String>> partition(String s) {
        if(s.length() == 0) return list ;
        backTrack(s , 0) ;
        return list ;
    }
    public static void backTrack(String s , int index){
        if(index == s.length()){
            list.add(new ArrayList<>(res)) ;
            return ;
        }
        for(int i = index ; i < s.length() ; i++){
            if(isPartition(s , index , i)){
                res.add(s.substring(index , i+1)) ;
                backTrack(s , i+1) ;
                res.remove(res.size() - 1) ;
            }
        }
    }
    /**
    * @Description: 判断字串是否是回文字串
    * @Param: [s：字符串, start：起始位置, end：终止位置]
    * @return: boolean
    * @Date: 2022/5/16
    */
    public static boolean isPartition(String s , int start , int end){
        if(start > end) return false ;
        while(start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++ ;
                end-- ;
            }else{
                return false ;
            }
        }
        return true ;
    }

}
