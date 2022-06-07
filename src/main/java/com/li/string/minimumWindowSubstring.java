package com.li.string;

import com.sun.glass.ui.Size;

/**
 * @Author: li wei kai
 * @Date: 2022/06/06/10:55
 * @Description:leetcode T76 题目：最小覆盖子串
 题目描述：
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，
则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
 
示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
示例 2：
    输入：s = "a", t = "a"
    输出："a"
示例 3:
    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。

进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class minimumWindowSubstring {
    //思路：滑动窗口
    //用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，
    // 当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最
    // 小值就是要求的结果。
    public static void main(String[] args) {
        String s = "AYIPSBSLCHBAOA" ;
        String t = "ABC" ;
        String minWindow = minWindow(s, t);
        System.out.println(minWindow);
    }
    //步骤：
    //1.不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
    //2.不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，直到碰到
    // 一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，记录此时滑动窗口的长度，并保存最小值
    //3.让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件
    // 的滑动窗口，如此反复，直到j超出了字符串S范围。

    //面临的问题：
    //1.如何判断滑动窗口包含了T的所有元素？
    //用一个长度为128(AscII码的数量)的数组来表示当前滑动窗口中需要的各元素的数量，一开始滑动窗口为空，用 t
    // 中各元素来初始化这个 arr，当滑动窗口扩展或者收缩的时候，去维护这个 arr 数组，例如当滑动窗口包含某个
    // 元素，我们就让arr中这个元素的数量减1，代表所需元素减少了1个；当滑动窗口移除某个元素，就让arr中这个元
    // 素的数量加1。
    //记住一点：arr 始终记录着当前滑动窗口下，我们还需要的元素数量，我们在改变left, right时，需同步维护arr。
    //值得注意的是，只要某个元素包含在滑动窗口中，我们就会在arr中存储这个元素的数量，如果某个元素存储的是负数
    // 代表这个元素是多余的。比如当arr等于{'A':-2,'C':1}时，表示当前滑动窗口中，我们有2个A是多余的，同时
    // 还需要1个C。这么做的目的就是为了步骤二中，排除不必要的元素，数量为负的就是不必要的元素，而数量为0表示
    // 刚刚好。
    //2.优化  减少计算时间
    // 回到问题中来，那么如何判断滑动窗口包含了T的所有元素？结论就是当arr中所有元素的数量都小于等于0时，表示
    // 当前滑动窗口不再需要任何元素。
    //如果每次判断滑动窗口是否包含了T的所有元素，都去遍历arr看是否所有元素数量都小于等于0，这个会耗费O(k)的
    // 时间复杂度，k代表字典长度，最坏情况下，k可能等于len(S)。
    //其实这个是可以避免的，我们可以维护一个额外的变量count来记录所需元素的总数量，当我们碰到一个所需元素c，
    // 不仅arr[c]的数量减少1，同时count也要减少1，这样我们通过count就可以知道是否满足条件，而无需遍历字典了。
    //前面也提到过，arr记录了遍历到的所有元素，而只有arr[c]>0大于0时，代表c就是所需元素
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "" ;
        //定义字符数组，
        int[] arr = new int[128] ;
        for (int i = 0 ; i < t.length() ; i++){
            arr[t.charAt(i)]++ ;
        }
        //index是最小覆盖串开始的下标, left是左边界, right是右边界, count是需求的字符个数, len记录窗口的大小
        int index = -1 , left = 0 , right = 0 , count = t.length() , len = Integer.MAX_VALUE ;
        //遍历所有字符，右指针到达边界时结束
        while (right < s.length()){
            char c = s.charAt(right) ;
            //遍历到需要的字符时，count数量减一
            if (arr[c] > 0) count-- ;
            arr[c]-- ;
            //此时t中的所有字符均在s中找到,接下来要做的就是收缩左边界,找到长度最短的一截
            if (count == 0){
                //收缩左边界
                while (left < right && arr[s.charAt(left)] < 0){
                    arr[s.charAt(left)]++ ;
                    left++ ;
                }
                //找到长度最短的一截字符串
                if (right - left + 1 < len){
                    len = right - left + 1 ;
                    //记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                    index = left ;
                }
                //left向右移动后窗口肯定不能满足了 重新开始循环
                arr[s.charAt(left)]++ ;
                count++ ;
                left++ ;
            }
            right++ ;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(index , index+len) ;
    }
}
