package com.li.doublePointer;

import java.util.Arrays;

/**
 * @Author: li wei kai
 * @Date: 2022/04/02/15:58
 * @Description: 题目：调整数组顺序使奇数位于偶数前面
 题目描述：
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分

实例：
    输入：nums = [1,2,3,4]
    输出：[1,3,2,4]
    注：[3,1,2,4] 也是正确的答案之一。
 */
public class exchange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7} ;
        int i = 0 , j = nums.length - 1 , temp ;
        while(i < j){
            while (i < j && nums[i] % 2 == 1){
                i++ ;
            }
            while (i < j && nums[j] % 2 == 0){
                j-- ;
            }
            temp = nums[i] ;
            nums[i] = nums[j] ;
            nums[j] = temp ;
        }
        System.out.println("调整顺序之后的数组为：" + Arrays.toString(nums));
    }
}
