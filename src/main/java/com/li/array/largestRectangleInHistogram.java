package com.li.array;

import java.util.Stack;

/**
 * @Author: li wei kai
 * @Date: 2022/06/14/21:07
 * @Description:leetcode T84 题目：柱状图中最大的矩形
 题目描述：
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

示例 1:
    输入：heights = [2,1,5,6,2,3]
    输出：10
    解释：最大的矩形为[5,6]。
示例 2：
    输入： heights = [2,4]
    输出： 4
 */
public class largestRectangleInHistogram {
    //思路：单调栈
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3} ;
        int largestRectangleArea = largestRectangleArea(heights);
        System.out.println(largestRectangleArea);
    }
    //解法思路：
    //对于任意一个位置，想要找到以该位置为高，可以向左和向右找到可以扩张的最大宽度，然后求出最大的面积
    //利用单调栈，栈中保存的值对应的搞逐渐增加。当碰到下一个低于当前高的值，就将当前高度弹出，进行面积计算
    //遍历到最后时，栈中还保存着部分数组值，再注意将其弹出并求出所对应的面积值。
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0 ;
        Stack<Integer> stack = new Stack<>() ;
        stack.push(-1) ;
        for(int i = 0 ; i < heights.length ; i++){
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                maxArea = Math.max(maxArea , heights[stack.pop()] * (i - stack.peek() - 1)) ;
            }
            stack.push(i) ;
        }
        while(stack.peek() != -1){
            maxArea = Math.max(maxArea , heights[stack.pop()] * (heights.length - stack.peek() - 1)) ;
        }
       return maxArea ;
    }
}
