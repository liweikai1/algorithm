package com.li.dynamicProgram;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/03/14:57
 * @Description:leetcode T416 题目：分割等和子集
 题目描述：
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：
    输入：nums = [1,5,11,5]
    输出：true
    解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
    输入：nums = [1,2,3,5]
    输出：false
    解释：数组不能分割成两个元素和相等的子集
 */
/*只有确定了如下四点，才能把01背包问题套到本题上来。
    1.背包的体积为sum / 2
    2.背包要放⼊的商品（集合⾥的元素）重量为 元素的数值，价值也为元素的数值
    3.背包如何正好装满，说明找到了总和为 sum / 2 的⼦集。
    4.背包中每⼀个元素是不可重复放⼊。
以上分析完，就可以套⽤01背包，来解决这个问题了。
* */
public class partitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5} ;
        boolean canPartition = canPartition(nums);
        System.out.println(canPartition);

    }
    //动态规划思路解析：
    //1. 确定dp数组以及下标的含义：01背包中，dp[j] 表示：容量为j的背包，所背的物品价值可以最⼤为dp[j]。
    //   套到本题，dp[j]表示 背包总容量是j，最⼤可以凑成j的⼦集总和为dp[j]。
    //2. 确定递推公式：01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    //   本题，相当于背包⾥放⼊数值，那么物品i的重量是nums[i]，其价值也是nums[i]。
    //   所以递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
    //3. dp数组如何初始化：在01背包，⼀维dp如何初始化，已经讲过，从dp[j]的定义来看，⾸先dp[0]⼀定是0。
    //   如果题⽬给的价值都是正整数那么⾮0下标都初始化为0就可以了，如果题⽬给的价值有负数，那么⾮0下标就要初始化为负⽆穷。
    //4. 确定遍历顺序：如果使⽤⼀维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，
    //   且内层for循环倒叙遍历
    //5. 举例推导dp数组：dp[i]的数值⼀定是⼩于等于i的。如果dp[i] == i 说明，集合中的⼦集总和正好可以凑成总和i，理解这⼀点很重要
    public static boolean canPartition(int[] nums) {
        //剪枝条件：如果nums中的元素个数不到两个，则无法拆分直接返回false
        if (nums.length < 2) return false ;
        int sum = 0 , maxNum = 0 ;
        for (int num : nums) {
            sum += num;
            if (num > maxNum) maxNum = num;
        }
        //如果数组总和是奇数，则不可能分割成两个相等的子集，故直接返回
        if (sum % 2 != 0) return false ;
        int target = sum / 2 ;
        //如果数组中的最大数大于数组的一半，则另外的数一定小于这一半，也无法分割成相等的两个子集，故直接返回
        if (maxNum > target) return false ;
        //dp数组初始值赋为0
        int[] dp = new int[target+1] ;
        //遍历数组中的数(相当于遍历背包问题中的物品)
        for (int i = 0 ; i < nums.length ; i++){
            //数组的一半就是要分割子集的总和，故将最大容量定位数组的一半。
            //倒叙遍历：防止将同一物品放两次
            for (int j = target ; j >= nums[i] ; j--){
                dp[j] = Math.max(dp[j] , dp[j-nums[i]] + nums[i]) ;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target] == target;
    }
}
