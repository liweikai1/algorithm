package com.li.greedy;

import java.util.PriorityQueue;

/**
 * @Author: li wei kai
 * @Date: 2022/03/16/18:23
 * @Description: LeetCode T179 最大数:
 * 题目：最大数  描述：给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数
示例 1:
输入：nums = [3,30,34,5,9]
输出："9534330"
 */
public class largestNumber {
    public static void main(String[] args) {
        int[] nums = {10 ,2 ,1} ;
        String largestNumber = largestNumber(nums);
        System.out.println("largestNumber = " + largestNumber);

    }
    /**
    * @Description: 在排序时定义比较器，通过比较(a+b)和(b+a)的大小，确定a和b的位置关系。
    * @Param: [nums]
    * @return: java.lang.String
    * @Date: 2022/3/19
    */
    /*public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }*/
    /**
    * @Description: 使用优先级队列，在放入数据时进行比较排序。
    * @Param: [nums]
    * @return: java.lang.String
    * @Date: 2022/3/19
    */
    public static String largestNumber(int[] nums) {
        PriorityQueue<String> priority = new PriorityQueue<>((x, y)->(y+x).compareTo(x+y)) ;
        for(int n : nums){
            priority.offer("" + n) ;
        }
        StringBuffer str = new StringBuffer() ;
        for(int i = 0 ; i < nums.length ; i++){
            str.append(priority.poll()) ;
        }
        int k = 0 ;
        while(k < nums.length - 1 && str.charAt(k) == '0'){
           k ++ ;
        }
        return str.toString().substring(k) ;
    }

}
