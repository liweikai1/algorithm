package com.li.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: li wei kai
 * @Date: 2022/03/25/19:20
 * @Description: 题目：第一个只出现一次的字符
 描述：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    示例 1:
        输入：s = "abaccdeff"
        输出：'b'
 */
public class firstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode" ;
        char uniqChar = firstUniqChar(s);
        System.out.println("第一个只出现一次的字符是：" + uniqChar);

    }
    /**
    * @Description: 使用哈希表：
     * 遍历字符串 s ，使用哈希表统计 “各字符数量是否 >1 ” 等于1为 true，大于1为 false。
      再遍历字符串 s ，在哈希表中找到首个 “数量为 1的字符” 即首个 value 值为 true 的，并返回。
    * @Param: [s]
    * @return: char
    * @Date: 2022/3/25
    */
    public static char firstUniqChar(String s) {
        Map<Character , Boolean> map = new HashMap<>() ;
        for(char c : s.toCharArray()){
            map.put(c , !map.containsKey(c)) ;
        }
        for(char c : s.toCharArray()){
            if(map.get(c)){
                return c ;
            }
        }
        return ' ' ;

    }
}
