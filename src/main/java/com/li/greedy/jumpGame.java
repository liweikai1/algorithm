package com.li.greedy;

/**
 * @Author: li wei kai
 * @Date: 2022/05/17/17:32
 * @Description:leetcode T55 题目：跳跃游戏
 题目描述：
给定一个非负整数数组 nums ，你最初位于数组的第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标

示例 1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

 */
public class jumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4} ;
        boolean canJump = canJump(nums);
        System.out.println(canJump);
    }
    //刚看到本题⼀开始可能想：当前位置元素如果是3，我究竟是跳⼀步呢，还是两步呢，还是三步呢，究竟跳⼏步才
    //是最优呢？其实跳⼏步⽆所谓，关键在于可跳的  覆盖范围！
    //不⼀定⾮要明确⼀次究竟跳⼏步，每次取最⼤的跳跃步数，这个就是可以跳跃的覆盖范围。
    //这个范围内，别管是怎么跳的，反正⼀定可以跳过来。
    //那么这个问题就转化为跳跃覆盖范围究竟可不可以覆盖到终点！

    //每次移动取最⼤跳跃步数（得到最⼤的覆盖范围），每移动⼀个单位，就更新最⼤覆盖范围。
    //贪⼼算法局部最优解：每次取最⼤跳跃步数（取最⼤覆盖范围），整体最优解：最后得到整体最⼤覆盖范围，看是
    //否能到终点.
    //i每次移动只能在cover的范围内移动，每移动⼀个元素，cover得到该元素数值（新的覆盖范围）的补充，让i继续
    //移动下去。
    //⽽cover每次只取 max(该元素数值补充后的范围, cover本身范围)。
    //如果cover⼤于等于了终点下标，直接return true就可以了
    public static boolean canJump(int[] nums) {
        int cover = 0 ;
        for (int i = 0 ; i <= cover ; i++){
            cover = Math.max(cover , i + nums[i]) ;
            if (cover >= nums.length - 1) return true ;
        }
        return false ;
    }
    //这道题⽬关键点在于：不⽤拘泥于每次究竟跳跳⼏步，⽽是看覆盖范围，覆盖范围内⼀定是可以跳过来的，不⽤管
    //是怎么跳的。
}
