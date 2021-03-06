package com.li.greedy;


/**
 * @Author: li wei kai
 * @Date: 2022/05/17/10:26
 * @Description:leetcode T376 题目：摆动序列
 题目描述：
如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
相反，[1,4,7,2,5]和[1,7,4,5,5]不是摆动序列，第一个序列是因为它的前两个差值都是正数，
第二个序列是因为它的最后一个差值为零。子序列 可以通过从原始序列中删除一些（也可以不删除）
元素来获得，剩下的元素保持其原始顺序。

给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。

示例 1：
    输入：nums = [1,7,4,9,2,5]
    输出：6
    解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
示例 2：
    输入：nums = [1,17,5,10,13,15,10,5,16,8]
    输出：7
    解释：这个序列包含几个长度为 7 摆动序列。
    其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
示例 3：
    输入：nums = [1,2,3,4,5,6,7,8,9]
    输出：2
 */
public class wiggleSubsequence {

    public static void main(String[] args) {
        int[] g = {1,17,5,10,13,15,10,5,16,8} ;
        int i = wiggleMaxLength(g);
        System.out.println(i);
    }
    //贪心算法：
    //局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
    //整体最优：整个序列有最多的局部峰值，从⽽达到最⻓摆动序列。
    //实际操作上，只需要统计数组的峰值数量就可以了（相当于是删除单⼀坡度上的节点，然后统计⻓度）
    //这就是贪⼼所贪的地⽅，让峰值尽可能的保持峰值，然后删除单⼀坡度上的节点。
    public static int wiggleMaxLength(int[] nums) {
        int cur = 0 ;
        int pre = 0 ;
        int ans = 1 ;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            cur = nums[i+1] - nums[i] ;
            if((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)){
                ans++ ;
                pre = cur ;
            }
        }
        return ans ;
    }
}
