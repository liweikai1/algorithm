package com.li.dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/05/16/22:02
 * @Description:leetcode T120 题目：三角形最小路径和
 题目描述：
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点
下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

示例 1：
    输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    输出：11
    解释：如下面简图所示：
        2
        3 4
        6 5 7
        4 1 8 3
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：
    输入：triangle = [[-10]]
    输出：-10
 */
public class triangle {
    public static void main(String[] args) {
        //创建list数组
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>() ;List<Integer> list2 = new ArrayList<>() ;List<Integer> list3 = new ArrayList<>() ;List<Integer> list4 = new ArrayList<>() ;
        list1.add(2) ; triangle.add(list1) ;
        list2.add(3);list2.add(4); triangle.add(list2);
        list3.add(6);list3.add(5);list3.add(7); triangle.add(list3);
        list4.add(4);list4.add(1);list4.add(8);list4.add(3); triangle.add(list4);

        int minPathSum = minPathSum(triangle);
        System.out.println(minPathSum);
    }
    //我们用 f[i][j]表示从三角形顶部走到位置(i,j)的最小路径和。这里的位置(i,j)指的是三角形中第i行第j列（均从 0 开始编号）的位置。
    //由于每一步只能移动到下一行「相邻的节点」上，因此要想走到位置(i,j)，上一步就只能在位置 (i−1,j−1) 或者
    // 位置 (i - 1, j)。我们在这两个位置中选择一个路径和较小的来进行转移，状态转移方程为：
    // f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]  其中 c[i][j] 表示位置 (i,j) 对应的元素值。
    //注意第i行有i+1个元素，它们对应的 j 的范围为 [0, i]。当 j=0或 j=i 时，上述状态转移方程中有一些项是
    // 没有意义的。例如当 j=0时，f[i-1][j-1]没有意义，因此状态转移方程为：f[i][0]=f[i-1][0]+c[i][0]
    //即当我们在第 i 行的最左侧时，我们只能从第 i−1 行的最左侧移动过来。当 j=i 时，f[i−1][j] 没有意义，
    // 因此状态转移方程为：f[i][i] = f[i-1][i-1] + c[i][i]
    //即当我们在第 i 行的最右侧时，我们只能从第 i−1 行的最右侧移动过来。
    //最终的答案即为 f[n−1][0] 到 f[n−1][n−1] 中的最小值，其中 n 是三角形的行数。
    public static int minPathSum(List<List<Integer>> triangle) {
        int m = triangle.size() ;
        int[][] dp = new int[m][m] ;
        dp[0][0] = triangle.get(0).get(0) ;
        dp[1][0] = dp[0][0] + triangle.get(1).get(0) ;
        dp[1][1] = dp[0][0] + triangle.get(1).get(1) ;
        for (int i = 2 ; i < m ; i++){
            for (int j = 0 ; j <= i ; j++){
                if (j == 0){
                    dp[i][0] = dp[i-1][0] + triangle.get(i).get(0) ;
                }else if (j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j) ;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j] , dp[i-1][j-1]) + triangle.get(i).get(j) ;
                }
                //打印dp数组
                for (int[] num : dp){
                    System.out.println(Arrays.toString(num));
                }
                System.out.println("------------这是分割线----------") ;
            }
        }
        int minNum = Integer.MAX_VALUE ;
        for(int num : dp[m-1]){
            if(num < minNum) minNum = num ;
        }
        return minNum ;
    }

}
