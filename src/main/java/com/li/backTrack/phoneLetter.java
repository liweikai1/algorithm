package com.li.backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: li wei kai
 * @Date: 2022/04/03/20:02
 * @Description: LeetCode T17 :电话号码的字母组合
 * 题目描述：给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 示例1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 示例2：
    输入：digits = "2"
    输出：["a","b","c"]
 */
public class phoneLetter {
    public static void main(String[] args) {
        String s = "23" ;
        List<String> letterCombinations = letterCombinations(s);
        System.out.println(letterCombinations);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.length() == 0) {
            return list;
        }
        //使用哈希表存储每个数字对应的所有可能的字母
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(list, map, digits, 0, new StringBuffer());
        return list;
    }

    /**
    * @Description: 回溯算法
    * @Param: [list, phoneMap, digits, index, combination]
    * @return: void
    * @Date: 2022/4/3
     思路：
    回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
    该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母
    插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完
    整的字母排列。然后进行回退操作，遍历其余的字母排列。
    */
    public static void backtrack(List<String> list, Map<Character, String> map, String digits, int index, StringBuffer str) {
        if (index == digits.length()) {
            list.add(str.toString());
        } else {
            char num = digits.charAt(index);
            String letters = map.get(num);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                str.append(letters.charAt(i));
                backtrack(list, map, digits, index + 1, str);
                str.deleteCharAt(index);
            }
        }
    }
}
