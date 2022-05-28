package com.li.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/05/23/15:49
 * @Description:leetCode T6 题目：Z字形变换
 题目描述：
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    P   A   H   N
    A P L S I I G
    Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class zigzagConversion {
    //解题思路：按顺序遍历字符串s时，每个字符c在Z字形中对应的行索 先从 s1增大至 sn，
    //        再从 sn 减小至 s1 …… 如此反复。
    // 解决方案为：模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i] 。
    public static void main(String[] args) {
        String s = "PAYPALISHIRING" ;
        String convert = convert(s, 3);
        System.out.println(convert);

    }
    //算法流程:按顺序遍历字符串 s ;
    // 1. res[i] += c： 把每个字符 c 填入对应行 si 中 ；
    // 2. i += flag： 更新当前字符 c 对应的行索引；
    // 3. flag = - flag： 在达到 Z 字形转折点时，执行反向。
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s ;
        List<StringBuilder> list = new ArrayList<>() ;
        for (int i = 0 ; i < numRows ; i++){
            list.add(new StringBuilder()) ;
        }
        int i = 0 , flag = -1 ;
        for (char c : s.toCharArray()){
            list.get(i).append(c) ;
            if (i == 0 || i ==  numRows - 1){
                flag = -flag ;
            }
            i += flag ;
        }
        StringBuilder str = new StringBuilder() ;
        for (StringBuilder li : list){
            str.append(li) ;
        }
        return str.toString() ;
    }
}
