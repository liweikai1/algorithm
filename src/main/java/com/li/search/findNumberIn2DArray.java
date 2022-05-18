package com.li.search;

/**
 * @Author: li wei kai
 * @Date: 2022/03/25/16:14
 * @Description: 题目：二维数组中的查找
  描述：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
  每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，
  判断数组中是否含有该整数。
 例：
[[1,   4,  7, 11, 15],[2,   5,  8, 12, 19],[3,   6,  9, 16, 22],[10, 13, 14, 17, 24],[18, 21, 23, 26, 30]]
答：给定 target = 5，返回 true。给定 target = 20，返回 false。
 *
 */
public class findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}} ;
        int target = 20;
        boolean numberIn2DArray = findNumberIn2DArray2(matrix, target);
        System.out.println("是否找到目标数字：" + numberIn2DArray);

    }

    /**
    * @Description: 暴力解法，时间复杂度较高.最差为 O（m*n） 不是最优解
    * @Param: [matrix, target]
    * @return: boolean
    * @Date: 2022/3/25
    */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length ;
        for(int i=0 ; i < n ; i++){
            int m = matrix[0].length - 1;
            int l = 0;
            while(l <= m){
                int mid = l + (m-l) / 2 ;
                if(matrix[i][mid] < target){
                    l = mid + 1;
                }else if (matrix[i][mid] > target){
                    m = mid - 1 ;
                }else {
                    return true ;
                }
            }
        }
        return false ;
    }

    /**
    * @Description: 利用该数组的性质，即每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
     * 通过遍历数组右上角的第一个值，判断该值比目标值大还是小，然后消去一行或者一列。
     * 此方法的时间复杂度为 O（m+n） 空间复杂都为 O（1）。速度有了明显的提升。
    * @Param: [matrix, target]
    * @return: boolean
    * @Date: 2022/3/25
    */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = 0 ;
        int m = matrix[0].length - 1 ;
        while(i < matrix.length && m >= 0){
            if(matrix[i][m] > target){
                m-- ;
            }else if(matrix[i][m] < target){
                i++ ;
            }else{
                return true ;
            }
        }
        return false ;
    }

}
