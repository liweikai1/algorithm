package com.li.code;

import java.util.Scanner;

/**
 * @Author: li wei kai
 * @Date: 2022/07/03/20:21
 * @Description:
 */
/*拼三角(ACM模式)
题目描述
给出6根棍子，能否在选出3根拼成一个三角形的同时剩下的3根也能组成一个三角形？

输入描述:
首先在一行中给出一个 t , 1 ≤ t ≤ 10^3代表测试数据的组数
接下来t行，每行给出 6 个数字代表棍子长度，棍子长度为正且小于 10^9

输出描述:
在一行中输出 “Yes” or “No”
* */
public class triangle {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T=cin.nextInt();
        int[] n=new int[6];
        int[] a=new int[6];
        int[] b=new int[6];
        while(T--!=0){
            boolean flag=false;
            for(int i=0;i<6;i++)
                n[i]=cin.nextInt();
            for(int i=(1<<6)-1;i>0;i--){
                int ai=0,bi=0;
                for(int j=5;j>=0;j--){
                    if(((i>>j)&1)==1){
                        a[ai++]=n[5-j];
                    }else{
                        b[bi++]=n[5-j];
                    }
                }
                if(ai==3&&bi==3&&IsTriangle(a)&&IsTriangle(b)){
                    flag=true;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
    public static boolean IsTriangle(int[] n){
        if(n[0]+n[1]>n[2]&&n[0]+n[2]>n[1]&&n[1]+n[2]>n[0])
            return true;
        return false;
    }
}
