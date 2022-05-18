package com.li.greedy;

/**
 * @Author: li wei kai
 * @Date: 2022/03/20/19:42
 * @Description: LeetCode T135, 分发糖果  题目描述：
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。你需要按照以下要求，给这些孩子分发糖果：
    1.每个孩子至少分配到 1 个糖果。
    2.相邻两个孩子评分更高的孩子会获得更多的糖果。
  请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
示例 1：
    输入：ratings = [1,0,2]
    输出：5
    解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
示例 2：
    输入：ratings = [1,2,2]
    输出：4
    解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
public class candy {
    //这道题⽬⼀定是要确定⼀边之后，再确定另⼀边，例如⽐较每⼀个孩⼦的左边，然后再⽐较右边，如果两边⼀起考虑⼀定会顾此失彼。
    //思路:
    //1.先确定右边评分⼤于左边的情况（也就是从前向后遍历）
    //  此时局部最优：只要右边评分⽐左边⼤，右边的孩⼦就多⼀个糖果，全局最优：相邻的孩⼦中，评分⾼的
    //  右孩⼦获得⽐左边孩⼦更多的糖果。局部最优可以推出全局最优。
    //2.再确定左边评分⼤于右边的情况（从后向前遍历）
    //  此时局部最优：只要左边评分⽐右边⼤，左边的孩⼦就多⼀个糖果，全局最优：相邻的孩⼦中，评分⾼的
    //  左孩⼦获得⽐右边孩⼦更多的糖果。局部最优可以推出全局最优。
    //3.取两个数组的最大值，然后求总和。
    public static void main(String[] args) {
        int[] ratings = {1 ,2 ,3 ,4 ,3 ,2 ,1} ;
        int n = ratings.length ;
        int[] left = new int[n] ;
        int[] right = new int[n] ;
        for (int i = 0 ; i < n ; i++){
            if (i-1 >= 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1 ;
            }else {
                left[i] = 1 ;
            }
        }
        for (int i = n-1 ;i >= 0 ; i--){
            if (i < n-1 && ratings[i] > ratings[i+1]){
                right[i] = right[i+1] + 1 ;
            }else {
                right[i] = 1 ;
            }
        }
        int count = 0 ;
        for (int i = 0 ; i < n ;i++){
            count += Math.max(left[i] , right[i]) ;
        }
        System.out.println("最少糖果数目为：" + count);
    }
}
