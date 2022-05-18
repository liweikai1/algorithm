package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/04/17:29
 * @Description:leetcode T474 题目：一和零
 题目描述：
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。请你找出并返回 strs 的最大子集的长度，
该子集中 最多 有 m 个 0 和 n 个 1 。如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集

示例 1：
    输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
    输出：4
    解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
    其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，
    因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：
    输入：strs = ["10", "0", "1"], m = 1, n = 1
    输出：2
    解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 */
public class findMaxForm {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"} ;
        int maxForm = findMaxForm(strs, 5, 3);
        System.out.println(maxForm);

    }
    //动态规划思路：判断时什么背包问题？
    //本题中strs 数组⾥的元素就是物品，每个物品都是⼀个！⽽m 和 n相当于是⼀个背包，两个维度的背包。
    //但本题其实是01背包问题！这不过这个背包有两个维度，⼀个是m ⼀个是n，⽽不同⻓度的字符串就是不同⼤⼩的待装物品。
    //1. 确定dp数组以及下标的含义：dp[i][j]：最多有i个0和j个1的strs的最⼤⼦集的⼤⼩为dp[i][j]
    //2. 确定递推公式：dp[i][j] 可以由前⼀个strs⾥的字符串推导出来，strs⾥的字符串有zeroNum个0，
    //   oneNum个1。dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
    //   然后我们在遍历的过程中，取dp[i][j]的最⼤值。
    //   所以递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
    //3. dp数组如何初始化：因为物品价值不会是负数，初始为0，保证递推的时候dp[i][j]不会被初始值覆盖。
    //4. 确定遍历顺序：01背包是外层for循环遍历物品，内层for循环遍历背包容量且从后向前遍历！
    //   那么本题物品就是strs⾥的字符串，背包容量就是题⽬描述中的m和n。
    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0){
            return 0 ;
        }
        int[][] dp = new int[m+1][n+1] ;
        for(String str : strs){
            //先计算当前字符串中，有多少个0和1
            int zero = 0 , one = 0 ;
            for(char ch : str.toCharArray()){
                if(ch == '0'){
                    zero++ ;
                }else{
                    one++ ;
                }
            }
            //根据背包容量进行动态递归
            for(int i = m ; i >=zero ; i-- ){
                for (int j = n ; j >= one ; j-- ){
                    dp[i][j] = Math.max(dp[i][j] , dp[i-zero][j-one] + 1) ;
                }
               for (int[] arr : dp){
                   System.out.println(Arrays.toString(arr));
               }
                System.out.println();
            }
            System.out.println("*********************");
        }
        return dp[m][n] ;
    }
}
