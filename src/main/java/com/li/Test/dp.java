package com.li.Test;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/05/04/21:08
 * @Description:
 */
public class dp {
    public static void main(String[] args) {
        int[] coins = {1,2,5} ;
        int amount = 5 ;
        int[] dp = new int[amount+1] ;
        dp[0] = 1 ;
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包容量
                dp[j] += dp[j - coins[i]];
                System.out.println(Arrays.toString(dp));
            }
            System.out.println();
        }
        System.out.println("---------此处是分割线---------");
        int[] dp1 = new int[amount+1] ;
        dp1[0] = 1 ;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp1[j] += dp1[j - coins[i]];
                System.out.println(Arrays.toString(dp1));
            }
            System.out.println();
        }
    }
}
