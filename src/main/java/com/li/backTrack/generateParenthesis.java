package com.li.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/27/17:32
 * @Description:leetcode T22 题目：括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class generateParenthesis {
    private static List<String> res = new ArrayList<>() ;

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(4);
        System.out.println(strings);
    }
    //回溯思路：
    //1.当前左右括号都有大于 0 个可以使用的时候，才产生分支；
    //2.产生左分支的时候，只看当前是否还有左括号可以使用；
    //3.产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
    //4.在左边和右边剩余的括号数都等于 0 的时候结算。
    public static List<String> generateParenthesis(int n) {
        if(n == 0) return res ;
        dfs(n , n , "") ;
        return res ;
    }
    public static void dfs(int left , int right , String str){
        if(left == 0 && right == 0){
            res.add(str) ;
            return ;
        }
        if(left > right) return ;
        if(left > 0){
            dfs(left - 1 , right , str+"(") ;
        }
        if(right > left){
            dfs(left , right - 1 , str+")" ) ;
        }
    }
}
