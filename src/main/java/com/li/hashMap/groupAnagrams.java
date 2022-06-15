package com.li.hashMap;

import java.util.*;

/**
 * @Author: li wei kai
 * @Date: 2022/06/13/16:45
 * @Description:leetcode T49 题目：字母异位词分组
 题目描述：
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

示例 1:
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:
    输入: strs = [""]
    输出: [[""]]
示例 3:
    输入: strs = ["a"]
    输出: [["a"]]
 */
public class groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"} ;
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }
    /**
    * @Description: 对字符进行排序
    两个字符串互为字母异位词，当且仅当两个字符串包含的字母相同。同一组字母异位词中的字符串具备相同点，
    可以使用相同点作为一组字母异位词的标志，使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的
    标志，哈希表的值为一组字母异位词列表。
    * @Param: [strs]
    * @return: java.util.List<java.util.List<java.lang.String>>
    * @Date: 2022/6/13
    由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
    故可以将排序之后的字符串作为哈希表的键
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>() ;
        for (String str : strs){
            char[] ch = str.toCharArray() ;
            Arrays.sort(ch) ;
            String key = new String(ch) ;
            List<String> res = map.getOrDefault(key , new ArrayList<String>()) ;
            res.add(str) ;
            map.put(key , res) ;
        }
        System.out.println(map.keySet());
        return new ArrayList<List<String>>(map.values()) ;
    }
}
