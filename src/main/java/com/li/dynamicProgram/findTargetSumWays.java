package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/05/04/11:24
 * @Description:leetcode T494 题目：目标和
 题目描述：
给你一个整数数组 nums 和一个整数 target 。向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，
可以构造一个 表达式 ： 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，
然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
示例 1：
    输入：nums = [1,1,1,1,1], target = 3
    输出：5
    解释：一共有 5 种方法让最终目标和为 3 。
        -1 + 1 + 1 + 1 + 1 = 3
        +1 - 1 + 1 + 1 + 1 = 3
        +1 + 1 - 1 + 1 + 1 = 3
        +1 + 1 + 1 - 1 + 1 = 3
        +1 + 1 + 1 + 1 - 1 = 3
示例 2：
    输入：nums = [1], target = 1
    输出：1
 */
public class findTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1} ;
        int target = 3 ;
        int targetSumWays = findTargetSumWays(nums, target);
        System.out.println(targetSumWays);

    }
    //动态规划思路：如何转化为01背包问题呢？
    //假设加法的总和为x，那么减法对应的总和就是sum - x。所以我们要求的是 x - (sum - x) = S
    //x = (S + sum) / 2 。因为sum 和 S 的值是固定的，所以 x 的值也可以当成固定值求出来。
    //此时问题就转化为，装满容量为x背包，有⼏种⽅法。本题是求装满有⼏种⽅法。其实这就是⼀个组合问题了。
    //1. 确定dp数组以及下标的含义：dp[j]表示填满j（包括j）这么⼤容积的包，有dp[j]种⽅法
    //2. 确定递推公式：有哪些来源可以推出dp[j]呢？不考虑nums[i]的情况下，填满容量为 j - nums[i] 的背包，
    //   有dp[j - nums[i]]中⽅法。那么只要找到nums[i]的话，凑成dp[j]就有 dp[j - nums[i]] 种⽅法。
    //   举⼀个例⼦,nums[i] = 2： dp[3]，填满背包容量为3的话，有dp[3]种⽅法。那么只需要搞到⼀个2（nums[i]），
    //   有dp[3]⽅法可以凑⻬容量为3的背包，相应的就有多少种⽅法可以凑⻬容量为5的背包。
    //   那么需要把这些⽅法累加起来就可以了，dp[i] += dp[j - nums[i]]。所以求组合类问题的公式，都是类似这种：
    //   dp[j] += dp[j - nums[i]]
    //3. dp数组如何初始化：从递归公式可以看出，在初始化的时候dp[0] ⼀定要初始化为1，因为dp[0]是在公式中⼀切递
    //   推结果的起源，如果dp[0]是0的话，递归结果将都是0。
    //   dp[0] = 1，理论上也很好解释，装满容量为0的背包，有1种⽅法，就是装0件物品。
    //   dp[j]其他下标对应的数值应该初始化为0，从递归公式也可以看出，dp[j]要保证是0的初始值，才能正确的由dp[j - nums[i]]推导出来。
    //4. 确定遍历顺序：对于01背包问题⼀维dp的遍历，nums放在外循环，target在内循环，且内循环倒序。
    //5. 举例推导dp数组
    public static int findTargetSumWays(int[] nums , int target) {
        int sum = 0 ;
        //剪枝条件：当数组总和比target小时，一定没有方案
        for(int num : nums){
            sum += num ;
        }
        if(sum < target) return 0 ;
        //剪枝条件：当sum和target的和为奇数时，没有方案
        if((sum + target) % 2 != 0){
            return 0 ;
        }
        int add = (sum + target) / 2 ;
        int[] dp = new int[add + 1] ;
        dp[0] = 1 ;
        //递归循环
        for (int num : nums) {
            for (int j = add; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[add] ;
    }
}
