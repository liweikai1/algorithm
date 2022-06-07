package com.li.array;

/**
 * @Author: li wei kai
 * @Date: 2022/05/28/20:06
 * @Description:leetcode T713 题目：乘积小于 K 的子数组
 题目描述：
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。

示例 1：
    输入：nums = [10,5,2,6], k = 100
    输出：8
    解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
    需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
示例 2：
    输入：nums = [1,2,3], k = 0
    输出：0
 */
public class subarrayProductLessK {
    //解题思路：滑动窗口
    public static void main(String[] args) {
        int[] nums = {1,1,1} ;
        int subarrayProductLessThanK = numSubarrayProductLessThanK(nums, 1) ;
        System.out.println(subarrayProductLessThanK);
    }
    //首先定义两个指针 left 和 right，后续遍历数组与记录用，
    //1.左右指针起始均在位置 0 ；用右指针遍历数组，每次循环中右指针右移一次；
    //2.移动过程中纪录从左指针到右指针路上的连续数的乘积为 mul；
    //3.如果乘积大于 k 了，则左指针右移，注意此处用的是 while 来使左指针右移，因为实际情况可能是：右指针最后右移
    //  一次指向了一个比较大的数使得 sum 不小于目标值，此时左指针需要右移多次才能使得 sum 刚小于 k；
    //4.最后用 ans 记录 sum 小于 k 时的数组组合；
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0 ;
        int ans = 0 , sum = 1 ;
        int left = 0 , right = 0 ;
        while (right < nums.length){
            sum *= nums[right] ;
            while (sum >= k){
                sum /= nums[left] ;
                left++ ;
            }
            ans += right - left + 1 ;
            right++ ;
        }
        return ans ;
    }
}
