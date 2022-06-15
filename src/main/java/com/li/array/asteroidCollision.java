package com.li.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: li wei kai
 * @Date: 2022/06/14/11:38
 * @Description:leetcode T735 题目：行星碰撞
给定一个整数数组 asteroids，表示在同一行的行星。对于数组中的每一个元素，其绝对值表示行星的大小，
正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，
则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

示例 1：
    输入：asteroids = [5,10,-5]
    输出：[5,10]
    解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
示例 2：
    输入：asteroids = [8,-8]
    输出：[]
    解释：8 和 -8 碰撞后，两者都发生爆炸。
示例 3：
    输入：asteroids = [10,2,-5]
    输出：[10]
    解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。

 */
public class asteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,-2} ;
        int[] asteroidCollision = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(asteroidCollision));
    }
    /**
    * @Description: 借助栈结构实现。主要是考虑什么时候入栈，什么时候出栈
    这道栈的题目难点应该主要是在分析场景上了。需要明确什么时候无脑入栈，什么时候需要判断。
    首先，循环每一个元素时，在什么情况下无脑入栈呢？
     1.栈为空
     2.栈顶元素为负数(下一个为负数则一起向左，下一个为正数则分向两边)
     3.当前元素为正数（栈顶为正一起向右，栈顶为负分向两边）
    接下来，我们需要看碰撞的场景又细分为什么情况：
     1.栈顶元素大于abs(当前元素)，当前元素被撞毁
     2.栈顶元素等于abs(当前元素)，栈顶弹出和当前元素抵消
     3.栈顶元素小于abs(当前元素)，栈顶弹出，并与新栈顶完成上述判断
    最终返回栈即可。
    * @Param: [asteroids]
    * @return: int[]
    * @Date: 2022/6/14
    */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int p = 0;
        while (p < asteroids.length) {
            if (s.empty() || s.peek() < 0 || asteroids[p] > 0) {
                s.push(asteroids[p]);
            } else if (s.peek() <= -asteroids[p]) {
                if (s.pop() < -asteroids[p]) {
                    continue;
                }
            }
            p++;
        }
        int[] ret = new int[s.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = s.pop();
        }
        return ret;
    }
}
