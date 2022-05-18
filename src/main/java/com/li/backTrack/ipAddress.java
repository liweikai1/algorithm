package com.li.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/05/01/14:54
 * @Description:leetcode T93 题目：复原 IP 地址
 题目描述：
有效 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），
整数之间用 '.' 分隔。
    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、
        "192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按任何顺序返回答案。
示例 1：
    输入：s = "0000"
    输出：["0.0.0.0"]
示例 2：
    输入：s = "101023"
    输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class ipAddress {
    private static List<String> list = new ArrayList<>() ;

    public static void main(String[] args) {
        String s = "101023" ;
        List<String> ipAddresses = restoreIpAddresses(s);
        System.out.println(ipAddresses);
    }

    public static List<String> restoreIpAddresses(String s) {
        //s的长度超出范围，直接剪枝
        if (s.length() < 4 || s.length() > 12){
            return list ;
        }
        backTrack(s ,0 , 0);
        return list ;
    }

    public static void backTrack(String s , int index , int spot){
        //终止条件：spot为3说明字符串分成了4段了。然后验证一下第四段是否合法，如果合法就加入到结果集里
        if (spot == 3){
            if (isValid(s , index , s.length() - 1 )){
                list.add(s) ;
            }
            return ;
        }
        for (int i = index ; i < s.length() - 1 ; i++){
            //递归调用时，下一层递归的index要从i+2开始（因为需要在字符串中加入了分隔符.），同时记录分割符的数量spot要 +1。
            //回溯的时候，就将刚刚i加入的分隔符. 删掉就可以了，spot 也要 -1。
            if (isValid(s , index , i)){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1); //在str的后⾯插⼊⼀个逗点
                spot++;
                backTrack(s, i + 2, spot);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                spot--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            }else {
                break ;
            }
        }
    }
    // 判断字符串s在左闭又闭区间[start, end]所组成的数字是否合法
    public static  boolean isValid(String s , int start , int end){
        //传入的字符串不合法
        if (start > end){
            return false ;
        }
        //含有前导0，不合法故剪枝
        if (s.charAt(start) == '0' && start != end){
            return  false ;
        }
        //将【start， end】中的数组转化为int类型
        int num = 0 ;
        for (int i = start ; i <= end ; i++){
            num = num * 10 + s.charAt(i) - '0' ;
        }
        //判断是否超出范围
        return num <= 255;
    }

}
