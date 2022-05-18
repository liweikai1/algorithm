package com.li.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: li wei kai
 * @Date: 2022/04/18/21:43
 * @Description:题目：最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
    //解题思路：滑动窗口(思路解析)
//    1.我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文
//     中的"枚举子串的起始位置"，而右指针即为文中的 l；
//    2.在每一步的操作中，我们会将左指针向右移动一格，表示开始枚举下一个字符作为起始位置，
//     然后可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
//     在移动结束后，这个子串就对应着以左指针开始的，不包含重复字符的最长子串。
//     我们记录下这个子串的长度；
//    3.在枚举结束后，我们找到的最长的子串的长度即为答案。
        String s = "asafsfdb" ;
        Set<Character> hset = new HashSet<>() ;
        int l = -1 ;
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(i != 0){
                hset.remove(s.charAt(i-1)) ;
            }
            while(l+1 < s.length() && !hset.contains(s.charAt(l+1))){
                hset.add(s.charAt(l+1)) ;
                l++ ;
            }
            ans = Math.max(ans , l-i+1) ;
        }
        System.out.println("最长不含重复字符的子字符串的长度为：" + ans);
    }
}
