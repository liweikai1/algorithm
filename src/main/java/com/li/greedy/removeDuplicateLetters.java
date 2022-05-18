package com.li.greedy;

import java.util.Stack;

/**
 * @Author: li wei kai
 * @Date: 2022/03/19/17:45
 * @Description:LeetCode T316 去除重复字母 题目描述:
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
示例 1：
    输入：s = "bcabc"
    输出："abc"
示例 2：
    输入：s = "cbacdcbc"
    输出："acdb"
 */
public class removeDuplicateLetters {
    public static void main(String[] args) {
        String s = "abacb" ;
        //定义栈结构，因为栈先入后出的特点，可以实时的对刚进入栈的数据操作
        Stack<Character> stack = new Stack<>() ;
        //定义布尔类型的数组，初始值为false,进入过栈的字符为true，实现去重
        boolean[] flag = new boolean[256] ;
        //计数器，统计在字符串中该字符出现的次数
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        //处理字符串中的每个字符
        for(char c : s.toCharArray()){
            //将字符c出现的次数减1，表示此次已经遍历过该字符
            count[c]-- ;
            //判断该字符是否进入过栈里
            if (flag[c]){
                continue;
            }
            while (!stack.empty() && stack.peek() > c){
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stack.peek()] == 0){
                    break;
                }
                // 若之后还有，则可以 pop
                flag[stack.pop()] = false ;
            }
            flag[c] = true ;
            stack.push(c) ;
        }
        //定义一个StringBuilder类型的字符串，用于拼接去重后的字符
        StringBuilder str = new StringBuilder() ;
        while (!stack.empty()){
            str.append(stack.pop()) ;
        }
        String string = str.reverse().toString();
        System.out.println("去除重复字母后的字符串为：" + string);

    }
}
