package com.li.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/04/20/21:38
 * @Description:LeetCode T54 题目：螺旋矩阵
 题目描述：
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：
    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[1,2,3,6,9,8,7,4,5]
 */
public class spiralOrder {
    //解题思路：
//    1.首先设定上下左右边界
//    2.其次向右移动到最右，此时第一行因为已经使用过了，可以将其从数组中删去，体现在代码中就是重新定义上边界
//    3.判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
//    4.若上下边界不交错，则遍历还未结束，接着向下、向左。向上移动，操作过程与第一，二步同理
//    5.不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}} ;
        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.println("返回的矩阵元素为：" + spiralOrder);

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        String s = "10011" ;
        List<Integer> list = new ArrayList<>() ;
        //判断matrix是否为空
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list ;
        //定义上下左右边界
        int left = 0 , right = matrix[0].length-1 , up = 0 , down = matrix.length-1 ;
        //循环判断
        while(true){
            //向左遍历
            for(int l = left ; l <= right ; l++){
                list.add(matrix[up][l]) ;
            }
            //去掉最上面一行，比较上下边界是否越界（具体体现就是上边界增一，相当于去掉上面一行）
            if(++up > down) break ;
            //向下遍历
            for(int u = up ; u <= down ; ++u){
                list.add(matrix[u][right]) ;
            }
            //去掉最右边一列，比较左右边界是否越界
            if(--right < left) break ;
            //向右遍历
            for(int r = right ; r >= left ;--r){
                list.add(matrix[down][r]) ;
            }
            //去掉最下面一行
            if(--down < up) break ;
            //向上遍历
            for(int d = down ; d >= up ; d--){
                list.add(matrix[d][left]) ;
            }
            //去掉最左边一列
            if(++left > right) break ;
        }
        return list ;
    }
}
