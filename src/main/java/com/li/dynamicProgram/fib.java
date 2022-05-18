package com.li.dynamicProgram;

/**
 * @Author: li wei kai
 * @Date: 2022/04/06/17:25
 * @Description:
 */
public class fib {
    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);

    }
    public static int fib(int n) {
        int a = 0 , b = 1 , sum = 1;
        for(int i=2 ; i < n ; i++){
            a = b ;
            b = sum ;
            sum = (a+b) % 1000000007 ;
        }
        return sum ;
    }
}
