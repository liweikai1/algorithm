package com.li.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: li wei kai
 * @Date: 2022/05/29/21:14
 * @Description:leetcode T560 题目：和为 K 的子数组
 题目描述：
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

示例 1：
    输入：nums = [1,1,1], k = 2
    输出：2
示例 2：
    输入：nums = [1,2,3], k = 3
    输出：2
 */
public class subarraySumEqualsK {
    //本题不能使用滑动窗口，因为数组里面可能包含负数。
    //所以本题采用前缀和的方式
    public static void main(String[] args) {
        int[] nums = {1,2,3,0,3,4,-1} ;
        int subarraySum = subarraySum(nums, 6);
        System.out.println(subarraySum);
    }
    //解题思路：
    //1.初始化一个空的哈希表和pre_sum=0的前缀和变量
    //2.设置返回值ret = 0，用于记录满足题意的子数组数量
    //3.循环数组的过程中，通过原地修改数组的方式，计算数组的累加和
    //4.将当前累加和减去整数K的结果，在哈希表中查找是否存在
    //5.如果存在该key值，证明以数组某一点为起点到当前位置满足题意，ret加等于将该key值对应的value
    //6.判断当前的累加和是否在哈希表中，若存在value+1，若不存在value=1
    //7.最终返回ret即可
    //但在这里要注意刚才说到的前缀和边界问题。
    //我们在计算这种场景时，需要考虑如果以数组nums[0]为开头的连续子数组就满足题意呢？
    //此时候我们的哈希表还是空的，没办法计算前缀和！所以遇到这类题目，都需要在哈希表中默认插入一个{0:1}的键值对，
    //用于解决从数组开头的连续子数组满足题意的特殊场景。
    public static int subarraySum(int[] nums, int k) {
        int pre_sum = 0 ;
        int ans = 0 ;
        Map<Integer , Integer> map = new HashMap<>() ;
        map.put(0 , 1) ;
        for (int i : nums){
            pre_sum += i ;
            ans += map.getOrDefault(pre_sum - k , 0) ;
            map.put(pre_sum , map.getOrDefault(pre_sum , 0) + 1) ;
        }
        return ans ;
    }

}
