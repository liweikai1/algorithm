package com.li.string;

import java.net.Inet4Address;
import java.util.*;

/**
 * @Author: li wei kai
 * @Date: 2022/06/23/16:36
 * @Description:leetcode T30 题目：串联所有单词的字串
 题目描述：
给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成
的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。

示例 1：
    输入：s = "barfoothefoobarman", words = ["foo","bar"]
    输出：[0,9]
    解释：从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
        输出的顺序不重要, [9,0] 也是有效答案。
示例 2：
    输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
    输出：[]
示例 3：
    输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
    输出：[6,9,12]
 */
public class substringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman" ;
        String[] words = {"bar","foo","the"} ;
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);
    }

    /**
    * @Description: 解法一：最直接的思路，判断每个子串是否符合，符合就把下标保存起来，最后返回
    * @Param: [s, words]
    * @Date: 2022/6/26
    * @return: java.util.List<java.lang.Integer>
    怎么判断子串是否符合？这也是这个题的难点了
    答：用两个 HashMap 来解决。首先，我们把所有的单词存到 HashMap 里，key 直接存单词，value 存单词出现的个数（因为给出的单词可能会
    有重复的，所以可能是 1 或 2 或者其他）。然后扫描子串的单词，如果当前扫描的单词在之前的 HashMap 中，就把该单词存到新的 HashMap 中，
    并判断新的 HashMap 中该单词的 value 是不是大于之前的 HashMap 该单词的 value ，如果大了，就代表该子串不是我们要找的，接着判断
    下一个子串就可以了。如果不大于，那么我们接着判断下一个单词的情况。子串扫描结束，如果子串的全部单词都符合，那么该子串就是我们找的其中一个
    */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>() ;
        int n = words.length ;
        int m = words[0].length() ;
        if(m * n > s.length()){
            return list ;
        }
        //HashMap1 存所有单词
        Map<String , Integer> map = new HashMap<>() ;
        for(String str : words){
            map.put(str , map.getOrDefault(str , 0) + 1) ;
        }
        //遍历所有子串(当剩余的字符串小于 m*n 就没必要进行比较了)
        for(int i = 0 ; i < s.length() - m * n + 1; i++){
            int num = 0 ;
            //HashMap2 存当前扫描的字符串含有的单词
            Map<String , Integer> cur = new HashMap<>() ;
            //判断该子串是否符合
            while(num < n){
                String li= s.substring(i + num * m , i + (num + 1) * m) ;
                //判断该单词在 HashMap1 中
                if (map.containsKey(li)){
                    cur.put(li , cur.getOrDefault(li , 0) + 1) ;
                    if (map.get(li) < cur.get(li)){
                        break ;
                    }
                }else {
                    break;
                }

              num++ ;
            }
            if(num == n){
                list.add(i) ;
            }
        }
        return list ;
    }
}
