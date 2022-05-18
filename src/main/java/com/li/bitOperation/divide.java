package com.li.bitOperation;

/**
 * @Author: li wei kai
 * @Date: 2022/04/21/21:13
 * @Description: LeetCode T29. 两数相除
 题目描述：
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
示例 1:
    输入: dividend = 10, divisor = 3
    输出: 3
    解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

 */
public class divide {
    //解题思路：
//    如果除法结果溢出，那么我们需要返回 2^{31} - 1 作为答案。因此在编码之前，我们可以首先对于溢出或者容易出错的边界情况进行讨论：
//      1.当被除数为 32 位有符号整数的最小值 -2^{31} 时：
//          1）如果除数为 1，那么我们可以直接返回答案 -2^{31} ；
//          2）如果除数为 -1，那么答案为 2^{31} ，产生了溢出。此时我们需要返回 2^{31} - 1
//      2.当除数为 32 位有符号整数的最小值 -2^{31} 时：
//          1）如果被除数同样为 -2^{31}，那么我们可以直接返回答案 1；
//          2）对于其余的情况，我们返回答案 0。
//      3.当被除数为 0 时，我们可以直接返回答案 0。
//    对于一般的情况，根据除数和被除数的符号，我们需要考虑 4 种不同的可能性。因此，为了方便编码，我们可
//    以将被除数或者除数取相反数，使得它们符号相同。
//    如果我们将被除数和除数都变为正数，那么可能会导致溢出。例如当被除数为 -2^{31}时，它的相反数 2^{31}
//    产生了溢出。
//    因此，我们可以考虑将被除数和除数都变为负数，这样就不会有溢出的问题，在编码时只需要考虑 1 种情况。
    public static void main(String[] args) {
        int a = Integer.MIN_VALUE ;
        int b = 2 ;
        int divide = divide(a, b);
        System.out.println(divide);
    }
    public static int divide(int dividend, int divisor) { // 被除数 除数
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;       //标志位 决定最后结果的正负
        if((dividend > 0 && divisor < 0)||(dividend < 0 && divisor > 0))
            sign = -1;
        // 都改为负号是因为int 的范围是[-2^32, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int ans = div(a,b);
        return sign == -1 ? -ans : ans;
    }
    public static int div(int a, int b) {
        if(a > b) return 0;
        int count = 1;
        int tb = b;
        while(tb+tb >= a && tb+tb < 0){ // 判定条件：溢出之后不再小于0，此时可结束循环
            tb += tb;
            count += count;
        }
        return count+div(a-tb,b);
    }
}
