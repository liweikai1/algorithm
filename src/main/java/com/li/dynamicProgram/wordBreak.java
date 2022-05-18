package com.li.dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/05/09/15:13
 * @Description:leetcode T139 题目：单词拆分
 题目描述：
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
示例 1：
    输入: s = "leetcode", wordDict = ["leet", "code"]
    输出: true
    解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：
    输入: s = "applepenapple", wordDict = ["apple", "pen"]
    输出: true
    解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
        注意，你可以重复使用字典中的单词。
示例 3：
    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    输出: false
 */
public class wordBreak {
    //动态规划思路：转化为背包问题
    // 单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。
    // 拆分时可以重复使⽤字典中的单词，说明就是⼀个完全背包！
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>(Arrays.asList("apple", "pen"));
        boolean wordBreak = wordBreak(s, wordDict);
        System.out.println(wordBreak);

    }
    //1. 确定dp数组以及下标的含义：dp[i]字符串⻓度为i的话，dp[i]为true，表示可以拆分为⼀个或多个在字典中出现的单词。
    //2. 确定递推公式：如果确定dp[j] 是true，且 [j, i] 这个区间的⼦串出现在字典⾥，那么dp[i]⼀定是true（j<i）。
    //   所以递推公式是  if([j, i] 这个区间的⼦串出现在字典⾥ && dp[j]是true) 那么 dp[i] = true。
    //3. dp数组如何初始化：从递归公式中可以看出，dp[i]的状态依靠 dp[j]是否为true，那么dp[0]就是递归的根基，
    //   dp[0]⼀定要为true，否则递归下去后⾯都都是false了。
    //   下标⾮0的dp[i]初始化为false，只要没有被覆盖说明都是不可拆分为⼀个或多个在字典中出现的单词。
    //4. 确定遍历顺序：题⽬中说是拆分为⼀个或多个在字典中出现的单词，所以这是完全背包。还要讨论两层for循环的前后循序。
    //   如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    //   如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    //   那么本题使⽤求排列的⽅式，还是求组合的⽅式都可以。即：外层for循环遍历物品，内层for遍历背包 或者外层for
    //   遍历背包，内层for循环遍历物品 都是可以的。
    //   但本题还有特殊性，因为是要求⼦串，最好是遍历背包放在外循环，将遍历物品放在内循环。
    //   如果要是外层for循环遍历物品，内层for遍历背包，就需要把所有的⼦串都预先放在⼀个容器⾥。（如果不理解的话，
    //   可以⾃⼰尝试这么写⼀写就理解了）
    //   所以最终选择的遍历顺序为：遍历背包放在外循环，将遍历物品放在内循环。内循环从前到后
    //5. 举例推导dp数组：手动推导
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict) ;
        boolean[] dp = new boolean[s.length()+1] ;
        dp[0] = true ;
        for (int j = 1 ; j <= s.length() ; j++){ // 遍历背包
            for (int i = 0 ; i < j ; i++){       // 遍历物品
                String substring = s.substring(i, j);
                if (dp[i] && set.contains(substring)){
                   dp[j] = true ;
                   break;
               }
            }
        }
        return dp[s.length()] ;
    }
}
