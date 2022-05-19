package com.li.greedy;

import java.util.*;

/**
 * @Author: li wei kai
 * @Date: 2022/05/18/22:40
 * @Description:leetcode T406 题目：根据身高重建队列
 题目描述：
假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个
people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

示例 1：
    输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    解释：
    编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
    编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
    编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
    编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
    编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
    编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
    因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
示例 2：
    输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
    输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

 */
public class queueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{6,0},{5,0},{4,0},{2,3},{2,2},{1,4}} ;
        int[][] reconstructQueue = reconstructQueue(people);
        for (int[] re : reconstructQueue){
            System.out.println(Arrays.toString(re));
        }
    }
    //先确定一个维度，按照身⾼h来排序，身⾼⼀定是从⼤到⼩排（身⾼相同的话则k⼩的站前⾯），让⾼个⼦在前⾯。
    // 此时我们可以确定⼀个维度了，就是身⾼，前⾯的节点⼀定都⽐本节点⾼！
    //按照身⾼排序之后，优先按身⾼⾼的people的k来插⼊，后序插⼊节点也不会影响前⾯已经插⼊的节点，
    // 最终按照k的规则完成了队列。
    //所以在按照身⾼从⼤到⼩排序后：
    //局部最优：优先按身⾼⾼的people的k来插⼊。插⼊操作过后的people满⾜队列属性
    //全局最优：最后都做完插⼊操作，整个队列满⾜题⽬队列属性
    public static int[][] reconstructQueue(int[][] people) {
        //排序规则: 对于n行两列的元素，先按数组的第一列进行降序排序，若某两行第一列相等，则按照第二列进一步排序。
        //二维数组排序：方法一实现Comparator接口 ：匿名内部类实现
        Arrays.sort(people , new Comparator<int[]>() {
            @Override
            public int compare(int[] a1 , int[] a2) {
                if (a1[0] == a2[0]) return a1[1] - a2[1] ;
                return a2[0] - a1[0] ;
            }
        });
       /* //二维数组排序：方法二lambda表达式实现
        Arrays.sort(people, (e1 , e2) ->
                (e1[0] == e2[0] ? (e1[1] - e2[1]) : (e1[0] - e2[0])));*/

        //打印数组，观察排序后的数组情况
        for (int[] peo : people){
            System.out.println(Arrays.toString(peo));
        }
        System.out.println("----------------这是分割线--------------");
        //构建链表集合或者创建list集合都可以
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            //此add()方法可以在指定位置插入元素。即：add(int index, E element)
            que.add(p[1],p);
        }
        //将list集合转化为int[][]数组
        return que.toArray(new int[people.length][2]);
    }
}
