package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/04/17/16:40
 * @Description:题目：把数字翻译成字符串
  题目描述：
 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，
 11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，
 用来计算一个数字有多少种不同的翻译方法
示例 1:
    输入: 12258
    输出: 5
    解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class translateNum {
    /*动态规划解析：
        记数字 num第 i 位数字为xi，数字 num 的位数为 n ；
        例如： num = 12258 的 n = 5, x1=1 。
    状态定义：设动态规划列表 dp ，dp[i] 代表以 xi 为结尾的数字的翻译方案数量。
    转移方程：若 xi和 x(i−1)组成的两位数字可以被翻译，则 dp[i] = dp[i-1] + dp[i-2] ；否则 dp[i] = dp[i - 1] 。
        可被翻译的两位数区间：当 x_{i-1} = 0时，组成的两位数是无法被翻译的（例如 00, 01, 02⋯ ），因此区间为[10,25] 。
            dp[i] = dp[i - 1] + dp[i - 2] , 10x(i−1) + xi ∈ [10,25]
            dp[i] = dp[i - 1] ,             10x(i−1) + xi ∈[0,10)∪(25,99]
    初始状态：dp[0]=dp[1]=1 ，即 “无数字” 和 “第 1 位数字” 的翻译方法数量均为 1 ；
    返回值：dp[n] ，即此数字的翻译方案数量。
     */
    public static void main(String[] args) {
        int num = 18822 ;
        int a = 1 ,b = 1 ;
        String str = String.valueOf(num) ;
        for(int i = 2 ; i <= str.length() ; i++){
            String s = str.substring(i-2,i) ;
            int temp = b ;
            if(s.compareTo("10") >=0 && s.compareTo("25") <=0){
                b += a ;
            }
            a = temp ;
        }
        System.out.println("数字的翻译方案为 ：" + b);
    }
}
