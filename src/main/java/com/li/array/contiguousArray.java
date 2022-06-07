package com.li.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: li wei kai
 * @Date: 2022/05/30/20:08
 * @Description:leetcode T525 题目：连续数组
 题目描述：
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

示例 1:
    输入: nums = [0,1]
    输出: 2
    说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
示例 2:
    输入: nums = [0,1,0]
    输出: 2
    说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。

 */
public class contiguousArray {
    //前缀和 + 哈希表 思想
    public static void main(String[] args) {
        int[] nums = {0 , 1} ;
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }
    //具体的，我们在预处理前缀和时，将 nums[i] 为 0 的值当做 −1 处理。
    //从而将问题转化为：如何求得最长一段区间和为 0 的子数组。
    //同时使用「哈希表」来记录「某个前缀和出现的最小下标」是多少。

    //核心：由于以上碰 1 加一，碰 0 减一的操作，当 0 与 1 数量一致时(连续数组), 其连续数组的和为零。因此我们知道
    //数组前面的 sum 值是什么，在到达该连续数组尾部时就不会变。因此我们只需要检查哈希表中是否存在其相同的 sum 值即可！

    //为什么要在哈希表中插入{0, -1}?
    //这是为了辅助讨论该连续数组的起始点在 index == 0 的位置的情况，如果最长连续数组在数组的最前方，
    // 不插入{0,-1}会得到错误的答案，因此我们一定要插入该辅助键值！

    public static int findMaxLength(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>() ;
        int sum = 0 , ans = 0 ;
        map.put(0 , -1) ;
        for (int i = 0 ; i < nums.length ; i++){
            sum += (nums[i] == 0 ? -1 : 1) ;
            if (map.containsKey(sum)){
                ans = Math.max(ans , i - map.get(sum)) ;
            }else {
                map.put(sum , i) ;
            }
        }
        return ans ;
    }
}
