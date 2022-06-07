package com.li.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: li wei kai
 * @Date: 2022/04/18/21:43
 * @Description:leetcode T3 题目：最长不含重复字符的子字符串
 题目描述：
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例 1:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是子串的长度，而"pwke" 是一个子序列，不是子串。
 */
public class longestSubstringWithoutRepeatingCharacters {
    //滑动窗口
    public static void main(String[] args) {
        String s = "pwweke" ;
        int ans = lengthOfLongestSubstring1(s);
        System.out.println("最长不含重复字符的子字符串的长度为：" + ans);
    }
    //解题思路：滑动窗口(思路解析)
//    1.我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文
//     中的"枚举子串的起始位置"，而右指针即为文中的 l；
//    2.在每一步的操作中，我们会将左指针向右移动一格，表示开始枚举下一个字符作为起始位置，
//     然后可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
//     在移动结束后，这个子串就对应着以左指针开始的，不包含重复字符的最长子串。
//     我们记录下这个子串的长度；
//    3.在枚举结束后，我们找到的最长的子串的长度即为答案。
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>() ;
        int l = -1 ;
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(i != 0){
                set.remove(s.charAt(i-1)) ;
            }
            while(l+1 < s.length() && !set.contains(s.charAt(l+1))){
                set.add(s.charAt(l+1)) ;
                l++ ;
            }
            ans = Math.max(ans , l-i+1) ;
        }
        return ans ;
    }
    //解题思路：滑动窗口，使用HashMap
    //1.首先我们创建一个哈希表map，并且初始化左边界left = 0，默认返回值len = 0
    //2.下来我们从0开始遍历字符串
    //3.每当遍历到字符串中的一个字符时，首先需要判断该字符是否在哈希表map中
    //4.如果该字符串没有在哈希表中，表示该字符不重复，无需移动左边界，将该字符串及对应下标加入哈希表中
    //5.如果该字符存在哈希表中，表示找到了重复的元素，此时我们需要移动左边界left
    //  1)若 left 小于哈希表中该字符对应的 index 下标，则移动至index + 1（因为index已经重复了，需要跳过）
    //  2)若 left 大于哈希表中该字符对应的 index 下标，表示重复的内容在左边界以外，忽略即可
    //  3)将当前字符串对应的下标更新哈希表中该字符串对应的下标
    //6.每次更新左边界后，比较当前滑窗长度与返回值大小并更新返回值
    //7.最终返回len即可。
    public static int lengthOfLongestSubstring1(String s){
        int len = 0 ;
        Map<Character , Integer> map = new HashMap<>() ;
        int left = 0 ;
        for(int right = 0 ; right < s.length() ; right++){
            char c = s.charAt(right) ;
            if (map.getOrDefault(c , 0) == 0){
                map.put(c , right) ;
            }else {
                int index = map.get(c);
                if (left <= index){
                    left = index + 1 ;
                }
                map.put(c, left) ;
            }
            len = Math.max(right - left + 1,len) ;
        }
        return len ;
    }
}
