package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/04/16/17:33
 * @Description:题目：礼物的最大价值
 * 题目描述：在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
示例 1:
    输入:
        [[1,3,1],
         [1,5,1],
         [4,2,1]]
    输出: 12
    解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 */
public class maxValue {
//    动态规划解题思路：
//    1.题目说明：从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
//    2.根据题目说明，易得某单元格只可能从上边单元格或左边单元格到达。
//    3.设 f(i, j) 为从棋盘左上角走至单元格 (i ,j) 的礼物最大累计价值，易得到以下递推关系：
//      f(i,j) 等于 f(i,j-1) 和 f(i-1,j) 中的较大值加上当前单元格礼物价值 grid(i,j) 。
//    4.f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
//    因此，可用动态规划解决此问题，以上公式便为转移方程。
    public static void main(String[] args) {
        int[][] grid = {{1,2,1},{1,2,1},{5,2,1}} ;
        int m = grid.length ;
        int n = grid[0].length ;
        //多加一行一列，可以避免讨论grid的边界问题；新创建的数组其值全部为0
        int[][] dp = new int[m+1][n+1] ;
        for(int i=1 ; i <= m ;i++){
            for (int j=1 ; j <= n ; j++){
                dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]) + grid[i-1][j-1] ;
            }
        }
        System.out.println(dp[m][n]);
    }
}