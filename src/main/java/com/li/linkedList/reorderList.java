package com.li.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/06/08/19:49
 * @Description:leetcode T143 题目：重排链表
 题目描述：
给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换

示例 1：
    输入：head = [1,2,3,4]
    输出：[1,4,2,3]
示例 2：
    输入：head = [1,2,3,4,5]
    输出：[1,5,2,4,3]
 */
public class reorderList {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "唐僧", "金蝉子");
        HeroNode hero2 = new HeroNode(2, "孙悟空", "齐天大圣");
        HeroNode hero3 = new HeroNode(3, "猪八戒", "天蓬元帅");
        HeroNode hero4 = new HeroNode(4, "沙和尚", "卷帘大将");

        //创建链表
        LinkedList singleLinkedList = new LinkedList();

        //向链表中加入各个节点
        singleLinkedList.add(hero1);singleLinkedList.add(hero2);singleLinkedList.add(hero3);singleLinkedList.add(hero4);

        //打印原链表
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        //打印重排之后的链表
        System.out.println("重排链表的情况~~");
        reorderList(singleLinkedList.getHead().next) ;
        singleLinkedList.list();
    }

    /**
    * @Description: 线性列表法
    因为链表不支持下标访问，所以我们无法随机访问链表中任意位置的元素。
    因此比较容易想到的一个方法是，我们利用线性表存储该链表，然后利用线性表可以下标访问的特点，
    直接按顺序访问指定元素，重建该链表即可。
    * @Param: [head]
    * @return: void
    * @Date: 2022/6/8
    */
    public static void reorderList(HeroNode head) {
        if (head == null) return ;
        List<HeroNode> list = new ArrayList<>() ;
        HeroNode cur = head ;
        while (cur != null){
            list.add(cur) ;
            cur = cur.next ;
        }
        int i = 0 , j = list.size() - 1 ;
        while (i < j){
            list.get(i).next = list.get(j) ;
            i++ ;
            if (i == j) break ;
            list.get(j).next = list.get(i) ;
            j-- ;
        }
        list.get(i).next = null ;
    }
    /**
    * @Description: 寻找链表中点 + 链表逆序 + 合并链表
     注意到目标链表即为将原链表的左半端和反转后的右半端合并后的结果。
     这样我们的任务即可划分为三步：
      1.找到原链表的中点。我们可以使用快慢指针来 O(N) 地找到链表的中间节点。
      2.将原链表的右半端反转。我们可以使用迭代法实现链表的反转。
      3.将原链表的两端合并。因为两链表长度相差不超过 1，因此直接合并即可。
    * @Param: [head]
    * @return: void
    * @Date: 2022/6/9
    */
    public static void reorderList1(HeroNode head) {

    }
}
