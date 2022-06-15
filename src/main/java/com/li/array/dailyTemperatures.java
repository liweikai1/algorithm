package com.li.array;

import java.util.Stack;

/**
 * @Author: li wei kai
 * @Date: 2022/06/14/16:56
 * @Description:leetcode T739 题目：每日温度
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 
是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:
    输入: temperatures = [73,74,75,71,69,72,76,73]
    输出: [1,1,4,2,1,1,0,0]
示例 2:
    输入: temperatures = [30,40,50,60]
    输出: [1,1,1,0]
示例 3:
    输入: temperatures = [30,60,90]
    输出: [1,1,0]
 */
public class dailyTemperatures {
    //思路：单调栈解法
    public static void main(String[] args) {

    }
    //解题步骤：
    //1.根据以上的信息，我们可以先创建一个temperatures等长的全零数组，然后初始化一个栈
    //2.这里注意由于需要返回相差天数，所以栈中需要保存元素下标来实现天数计算。
    //3.下来循环temperatures进行栈的操作，循环过程中，持续判断当前下标温度与栈顶下标温度的大小差别
    //4.如果当前下标的温度大于栈顶下标的温度，表示找到了下一个更大的温度，弹出栈顶下标，计算天数差别，
    //5.更新ans[栈顶下标] = 当前下标 - 栈顶下标
    //6.否则将当前下标加入栈顶
    //7.ans中没有更新的元素，表示未找到更高的温度，最终返回ans即可。
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>() ;
        int len = temperatures.length ;
        int[] ans = new int[len] ;
        for(int i = 0 ; i < len ; i++){
            int temperature = temperatures[i] ;
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int ind = stack.pop() ;
                ans[ind] = i - ind ;
            }
            stack.push(i) ;
        }
        return ans ;
    }

}
