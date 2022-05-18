package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/02/16:42
 * @Description:leetcode T63 题目：不同路径II
 题目描述：
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。机器人每次只能向下或者向右移动一步。
机器人试图达到网格的右下角（在下图中标记为 “Finish”）。现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。
 示例1：
    输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    输出：2
    解释：3x3 网格的正中间有一个障碍物。
    从左上角到右下角一共有 2 条不同的路径：
    1. 向右 -> 向右 -> 向下 -> 向下
    2. 向下 -> 向下 -> 向右 -> 向右
 示例2：
    输入：obstacleGrid = [[0,1,0],[0,1,0],[0,1,0]]
    输出：2
 */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,1,0},{0,1,0},{0,1,0}} ;
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);

    }
    //动态规划思路：01背包问题
    //1. 确定dp数组（dp table）以及下标的含义：dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
    //2. 确定递推公式：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]。
    //3. dp数组如何初始化：如果障碍物在第一行或者第一列：那么障碍物之后的路径都为0，因为无法越过障碍物到达后面的格子，
         //如果障碍物在中间则需要将该点的可达路径置为0。如果障碍物在起点，则无可同行路径。
    //4. 确定遍历顺序：从递归公式dp[i][j] = dp[i-1][j] + dp[i][j-1] 中可以看出，⼀定是从左到右⼀层⼀层遍历，
    // 这样保证推导 dp[i][j]的时候，dp[i - 1][j] 和 dp[i][j - 1]⼀定是有数值。
    //5. 举例推导dp数组：手动推导。
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length ;
        int[][] dp = new int[m][n] ;
        for(int i = 0 ; i < m ; i++){
            if(obstacleGrid[i][0] != 1){
                dp[i][0] = 1 ;
            }else {
                break ;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(obstacleGrid[0][i] != 1){
                dp[0][i] = 1 ;
            }else {
                break ;
            }
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0 ;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] ;
                }

            }
        }
        for (int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[m-1][n-1] ;
    }
}
