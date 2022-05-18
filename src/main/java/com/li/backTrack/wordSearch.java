package com.li.backTrack;

/**
 * @Author: li wei kai
 * @Date: 2022/04/03/15:11
 * @Description: LeetCode T79 题目：单词搜索
 题目描述：
给定一个mxn二维字符网格 board 和一个字符串单词 word 。如果word存在于网格中，返回 true ；否则，返回 false。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

示例1：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true
示例2：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true
示例3：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    输出：false

 */
public class wordSearch {
    //设置四个方向的偏移量，表示在搜索时向四个方向上搜索
    //注意：偏移量数组在二维平面内是经常使用的，可以把它的设置当做一个技巧，并且在这个问题中，偏移量数组内的 4 个偏移的顺序无关紧要；
    private static final int[][] DIRECTIONS = {{-1,0} , {0,1} , {1,0} , {0,-1}} ;
    //设置标志位数组，true时表示该位置已经被搜索过，当回溯时不可再此使用该位置的数
    //标志位数组在回溯题目和动态规划中经常使用，可以当作技巧记下来
    private static boolean[][] visited ;
    //定义二维数组的行和列，方便各个函数调用
    private static int m  ;
    private static int n ;

    /**
    * @Description: 主函数，用于输出结果验证对错
    * @Param: [args]
    * @return: void
    * @Date: 2022/4/3
    */
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        String word = "ABCB" ;
        boolean exist = exist(board, word);
        System.out.println("该单词在数组中是否存在：" + exist);
    }

    /**
    * @Description: 判断该单词在数组中是否存在
    * @Param: [board , word]
    * @return: boolean
    * @Date: 2022/4/3
    */
    public static boolean exist(char[][] board , String word){
        //初始化数组，不符合条件直接返回
        if (board == null || board.length == 0) return false ;
        m = board.length ;
        n = board[0].length ;
        char[] li = word.toCharArray() ;
        //设置标志位数组的大小
        visited = new boolean[m][n] ;
        //循环遍历二维数组中的每一个数，逐个判断是否符合要求
        for (int i=0 ; i<m ; i++){
            for (int j=0 ; j<n ; j++){
                if (dfs(board ,li ,i ,j ,0 ,visited)) return true ;
            }
        }
        return false ;
    }
    /**
    * @Description: 深度优先遍历：从该点开始进行匹配，匹配成功则开始匹配下一个，不成功返回上一步换方向重新匹配
    * @Param: [board, li, i, j, k, visited]
    * @return: boolean
    * @Date: 2022/4/3
    */
    public static boolean dfs(char[][] board ,char[] li ,int i ,int j ,int k ,boolean[][] visited){
        if (k == li.length - 1) return board[i][j] == li[k] ;
        if (board[i][j] == li[k]){
            visited[i][j] = true ;
            for (int[] dir : DIRECTIONS){
                int newX = i + dir[0] ;
                int newY = j + dir[1] ;
                if (isArea(newX , newY) && !visited[newX][newY]){
                    if (dfs(board ,li ,newX ,newY ,k+1 ,visited)) return true ;
                }
            }
            visited[i][j] = false ;
        }
        return false ;
    }

    /**
    * @Description: 判断二维数组中该点的坐标是否在边界内，如果在返回 true，不在返回 false.
    * @Param: [x, y]
    * @return: boolean
    * @Date: 2022/4/3
    */
    public static boolean isArea(int x , int y){
        return x >= 0 && y >= 0 && x < m && y < n ;
    }

}
