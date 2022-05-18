package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/12/15:46
 * @Description:leetcode T718 题目：最长重复子数组
 题目描述：
给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。

示例 1：
    输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    输出：3
    解释：长度最长的公共子数组是 [3,2,1] 。
示例 2：
    输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    输出：5
 */
public class maxNumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,3,2} ;
        int[] nums2 = {2,1,1,1,1} ;
        int length = findLength(nums1, nums2);
        System.out.println(length);
    }
    //1. 确定dp数组以及下标的含义：dp[i][j] ：以下标 i-1 为结尾的A，和以下标 j-1 为结尾的B，
    //   最⻓重复⼦数组⻓度为dp[i][j]。
    //   其实dp[i][j]的定义也就决定着，我们在遍历dp[i][j]的时候i 和 j都要从1开始。
    //2. 确定递推公式：根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
    //   即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
    //   根据递推公式可以看出，遍历i 和 j 要从1开始！
    //3. dp数组如何初始化：根据dp[i][j]的定义，dp[i][0] 和dp[0][j]其实都是没有意义的！
    //   但dp[i][0] 和dp[0][j]要初始值，因为为了⽅便递归公式dp[i][j] = dp[i-1][j-1] + 1;
    //   所以dp[i][0] 和dp[0][j]初始化为0。
    //4. 确定遍历顺序：外层for循环遍历A，内层for循环遍历B。。
    //   同时题⽬要求⻓度最⻓的⼦数组的⻓度。所以在遍历的时候顺便把dp[i][j]的最⼤值记录下来。
    //5. 举例推导dp数组
    public static int findLength(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return 0 ;
        int[][] dp = new int[nums1.length+1][nums2.length+1] ;
        int result = 1 ;
        for(int i = 1 ; i <= nums1.length ; i++){
            for(int j = 1 ; j <= nums2.length ; j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }
                if (dp[i][j] > result) result = dp[i][j] ;
                for (int[] d : dp){
                    System.out.println(Arrays.toString(d));
                }
                System.out.println("----------这是分割线-----------");
            }

        }
        return result ;
    }
}
