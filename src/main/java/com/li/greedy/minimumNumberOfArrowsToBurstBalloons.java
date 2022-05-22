package com.li.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: li wei kai
 * @Date: 2022/05/19/16:22
 * @Description:leetcode T452 题目：用最少数量的箭引爆气球
 题目描述：
有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。
你不知道气球的确切 y 坐标。一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。

示例 1：
    输入：points = [[10,16],[2,8],[1,6],[7,12]]
    输出：2
    解释：气球可以用 2支箭来爆破:
        -在x = 6处射出箭，击破气球[2,8]和[1,6]。
        -在x = 11处发射箭，击破气球[10,16]和[7,12]。
示例 2：
    输入：points = [[1,2],[3,4],[5,6],[7,8]]
    输出：4
    解释：每个气球需要射出一支箭，总共需要4支箭。

 */
public class minimumNumberOfArrowsToBurstBalloons {
    //贪心算法：
    //局部最优：当⽓球出现重叠，⼀起射所⽤⼸箭最少。全局最优：把所有⽓球射爆所⽤⼸箭最少。
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}} ;
        /*int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}} ;*/
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
    //为了让⽓球尽可能的重叠，需要对数组进⾏排序。按照起始区间从小到大进行排序
    //按照起始位置排序，那么就从前向后遍历⽓球数组，靠左尽可能让⽓球重复。
    //从前向后遍历遇到重叠的⽓球，那么取重叠⽓球中右边边界的最⼩值，而这之前的区间⼀定需要⼀个⼸箭。
    //这样将两个区间(或者多个区间)就归为一个区间。
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int[] p : points){
            System.out.println(Arrays.toString(p));
        }
        System.out.println("---------这是分割线--------");
        int count = 1 ;
        for (int i = 1 ; i < points.length ; i++){
            //当前区间和上一个区间无重叠
            if (points[i][0] > points[i-1][1]){
                count++ ;
            }else{
            //当前区间和上一个有重叠，将当前区间的尾值转化为上一个区间的尾值。
                points[i][1] = Math.min(points[i][1] , points[i-1][1]) ;
            }
        }
        for (int[] p : points){
            System.out.println(Arrays.toString(p));
        }
        System.out.println("---------这是分割线--------");
        return count ;
    }
}
