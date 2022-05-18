package com.li.doublePointer;

/**
 * @Author: li wei kai
 * @Date: 2022/04/02/16:40
 * @Description: 题目：翻转单词顺序
 题目描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 例如输入字符串"I am a student. "，则输出"student. a am I"。
示例 1：
    输入: "  hello world!  "
    输出: "world! hello"
    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：
    输入: "a good   example"
    输出: "example good a"
    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class reverseWords {
    public static void main(String[] args) {
        String s = " I am a boy! " ;
        s = s.trim() ;
        int j = s.length() - 1 ,i = j ;
        StringBuilder res = new StringBuilder() ;
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' '){
                i-- ;
            }
            res.append(s, i+1, j+1 ).append(' ') ;
            while (i >= 0 && s.charAt(i) == ' '){
                i-- ;
            }
            j = i ;
        }
        String string = res.toString().trim();
        System.out.println("翻转后的单次顺序是" + string);

    }
}
