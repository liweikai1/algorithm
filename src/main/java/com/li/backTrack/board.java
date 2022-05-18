package com.li.backTrack;

/**
 * @Author: li wei kai
 * @Date: 2022/04/27/14:25
 * @Description:leetcode T130.题目：被围绕的区域
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
并将这些区域里所有的 'O' 用 'X' 填充。
示例：
    输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
        任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
        如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class board {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}} ;
    private static int n ;
    private static int m ;

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X' }, {'X', 'O', 'O', 'X' }, {'X', 'X', 'O', 'X' }, {'X', 'O', 'X', 'X' }};
        for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        solve(board);
        System.out.println("*************");
        for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length ; j ++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        if(board == null) return  ;
        n = board.length ;
        m = board[0].length ;
        boolean[][] visited = new boolean[n][m] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(isBorder(i , j)){
                    backTrack(board , i , j , visited) ;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X' ;
                }
            }
        }
    }
    //搜索在边界及其相连的“O”，并将对应位置的visited置true，
    public static void backTrack(char[][]board , int i , int j , boolean[][] visited){
        if(board[i][j] == 'O'){
            visited[i][j] = true ;
            for(int[] dir : DIRECTIONS){
                int newI = i + dir[0] ;
                int newJ = j + dir[1] ;
                if(isArea(newI , newJ) && !visited[newI][newJ]){
                    backTrack(board , newI , newJ , visited) ;
                }
            }
        }

    }
    //判断当前点是否在边界上
    public static boolean isBorder(int i , int j){
        return i == 0 || j == 0 || i == n-1 || j == m-1 ;
    }
    //判断当前点是否在矩阵board内
    public static boolean isArea(int i , int j){
        return i >=0 && j >= 0 && i < n && j < m ;
    }
}
