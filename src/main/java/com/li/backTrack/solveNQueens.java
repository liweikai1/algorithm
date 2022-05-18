package com.li.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/28/11:39
 * @Description:leetcode T51 题目：N皇后
 题目描述：
n皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 示例：
    输入：n = 4
    输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class solveNQueens {
    private static List<List<String>> list = new ArrayList<>() ;
    private static int sum = 0 ;

    public static void main(String[] args) {
        List<List<String>> solveNQueens = solveNQueens(4);
        System.out.println(solveNQueens);
        System.out.println(sum);
    }
    public static List<List<String>> solveNQueens(int n) {
        //创建棋盘 ，空位为'.'
        char[][] chessBoard = new char[n][n] ;
        //可以在指定位置进行数值填充。
        for(char[] chars : chessBoard){
            Arrays.fill(chars , '.') ;
        }
       backTrack(n , 0 , chessBoard);
        return list ;
    }
    //回溯，搜索皇后可以放的位置，
    public static void backTrack(int n , int row , char[][] chessBoard){
        //从row=0开始，当row=n时表示遍历完一遍，如符合要求则加入list集合中
        if (row == n){
            list.add(genList(chessBoard)) ;
            sum++ ;
            return ;
        }
        //根据二维矩阵的构造，这是按行遍历，从第一行第一列到第一行最后一列。
        for (int col = 0 ; col < n ; col++){
            //不能互相攻击
            if (isAttack(row , col , n , chessBoard)){
                //放置皇后
                chessBoard[row][col] = 'Q' ;
                //探索下层皇后的放置位置
                backTrack(n , row + 1 , chessBoard);
                //回溯，标识当前层无位置可放，需重置上层位置，
                chessBoard[row][col] = '.' ;
            }
        }
    }
    //判断皇后放置的当前位置能否能相互攻击。即不能放在同一行，同一列，还不能在两条对角线上(45°和135°)
    public static boolean isAttack(int row , int col , int n , char[][] chessBoard){
        //判断当前列是否有皇后，有的话返回false
        for (int i = 0 ; i < row ; i++){
            if (chessBoard[i][col] == 'Q'){
                return false ;
            }
        }
        //判断当前对角线(45°)上是否有皇后，从当前位置向45°方向搜索皇后，有的话返回false
        for (int i = row - 1 , j = col + 1 ; i >= 0 && j < n ; i-- , j++){
            if (chessBoard[i][j] == 'Q'){
                return false ;
            }
        }
        //判断当前对角线(135°)上是否有皇后，从当前位置向135°方向搜索皇后，有的话返回false
        for (int i = row - 1 , j = col - 1 ; i >= 0 && j >= 0 ; i--, j--){
            if (chessBoard[i][j] == 'Q'){
                return false ;
            }
        }
        return true ;
    }
    //因为题目要求的是 List<String> 形式，所以需要将char[]类型的数组转化一下
    public static List<String> genList(char[][] chessBoard){
        List<String> res = new ArrayList<>() ;
        //将char[]数组的值复制到字符串中
        for (char[] chars : chessBoard){
            res.add(String.copyValueOf(chars)) ;
        }
        return res ;
    }
}
