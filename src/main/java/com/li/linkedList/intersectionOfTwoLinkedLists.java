package com.li.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: li wei kai
 * @Date: 2022/06/08/15:18
 * @Description:leetcode T160 题目：相交链表
 题目描述：
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
如果两个链表不存在相交节点，返回 null 。
题目数据 保证 整个链式结构中不存在环。注意，函数返回结果后，链表必须 保持其原始结构 。

    intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
    listA - 第一个链表
    listB - 第二个链表
    skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
    skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
示例1：
    输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    输出：Intersected at '8'
    解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
        从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
        在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
示例2：
    输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    输出：Intersected at '2'
    解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
        从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
        在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 */
public class intersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode hero8 = new HeroNode(8, "呼延灼", "双鞭");
        HeroNode hero9 = new HeroNode(9, "花容", "小李广");

        //创建链表
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        //向两个链表中加入各个节点
        list1.add(hero1); list1.add(hero2); list1.add(hero3); /*list1.add(hero8); list1.add(hero9);*/
        list2.add(hero4); list2.add(hero5); list2.add(hero6); list2.add(hero7); /*list2.add(hero8); list2.add(hero9);*/
        //打印原链表
        System.out.println("链表A~~");
        list1.list();
        System.out.println("链表B~~");
        list2.list();
    }
    //哈希表法：
    //判断两个链表是否相交，可以使用哈希集合存储链表节点。
    //首先遍历链表 headA，并将链表}headA 中的每个节点加入哈希集合中。然后遍历链表 headB，对于遍历到的每个节点，
    //判断该节点是否在哈希集合中：
    //   如果当前节点不在哈希集合中，则继续遍历下一个节点；
    //   如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在两个链表的相交部分，
    //     因此在链表 headB 中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回该节点。
    //如果链表 headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回 null
    public static HeroNode getIntersectionNode(HeroNode headA, HeroNode headB) {
        Set<HeroNode> visited = new HashSet<HeroNode>();
        HeroNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //双指针法：
    //使用双指针的方法，可以将空间复杂度降至 O(1)。
    //只有当链表 headA 和 headB 都不为空时，两个链表才可能相交。因此首先判断链表 headA 和 headB 是否为空，
    // 如果其中至少有一个链表为空，则两个链表一定不相交，返回 null。
    //当链表 headA 和 headB 都不为空时，创建两个指针 pA 和 pB，初始时分别指向两个链表的头节点 headA 和
    //headB，然后将两个指针依次遍历两个链表的每个节点。具体做法如下：
    //   每步操作需要同时更新指针 pA 和 pB。
    //   如果指针 pA 不为空，则将指针 pA 移到下一个节点；如果指针 pB 不为空，则将指针 pB 移到下一个节点。
    //   如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；如果指针 pB 为空，则将指针 pB 移到链表 headA 的头节点。
    //   当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者null。
    public static HeroNode getIntersectionNode1(HeroNode headA, HeroNode headB) {
        if (headA == null || headB == null){
            return null ;
        }
        HeroNode pA = headA ;
        HeroNode pB = headB ;
        while (pA != pB){
            pA = pA == null ? headB : pA.next ;
            pB = pB == null ? headA : pB.next ;
        }
        return pA ;
    }
}
