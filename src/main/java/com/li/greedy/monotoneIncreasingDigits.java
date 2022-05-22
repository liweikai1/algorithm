package com.li.greedy;

/**
 * @Author: li wei kai
 * @Date: 2022/05/20/17:22
 * @Description:leetcode T738 题目：单调递增的数字
 题目描述：
当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。

示例 1:
    输入: n = 10
    输出: 9
示例 2:
    输入: n = 1234
    输出: 1234
示例 3:
    输入: n = 332
    输出: 299
 */
public class monotoneIncreasingDigits {
    //贪心算法
    public static void main(String[] args) {
        int n = 332 ;
        int increasingDigits = monotoneIncreasingDigits(n);
        System.out.println(increasingDigits);
    }
    //局部最优：遇到num[i - 1] > num[i]的情况，让num[i - 1]--，然后num[i]给为9，
    // 可以保证这两位变成最⼤单调递增整数。
    //全局最优：得到⼩于等于N的最⼤单调递增的整数。
    //但这⾥局部最优推出全局最优，还需要其他条件，即遍历顺序，和标记从哪⼀位开始统⼀改成9
    //那么从后向前遍历，就可以重复利⽤上次⽐较得出的结果了
    public static int monotoneIncreasingDigits(int n) {
        char[] num = String.valueOf(n).toCharArray() ;
        // flag⽤来标记赋值9从哪⾥开始
        // 设置为这个默认值，为了防⽌第⼆个for循环在flag没有被赋值的情况下执⾏
        int flag = num.length ;
        for(int i = num.length - 1 ; i > 0 ; i--){
            if(num[i-1] > num[i]){
                flag = i ;
                num[i-1]-- ;
            }
        }
        for(int i = flag ; i < num.length ; i++){
            num[i] = '9' ;
        }
        return Integer.parseInt(new String(num)) ;
    }
}
