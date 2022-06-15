package com.li.hashMap;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: li wei kai
 * @Date: 2022/06/12/16:25
 * @Description:leetcode T146 题目：LRU缓存
 题目描述：
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
    LRUCache(int capacity): 以 正整数 作为容量 capacity 初始化 LRU 缓存
    int get(int key): 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value): 如果关键字 key 已经存在，则变更其数据值 value ；
        如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
        则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

 示例1：
    输入：["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    输出：[null, null, null, 1, null, -1, null, -1, 3, 4]
    解释：
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
 */
public class lruCache {
    private static int size ;
    private static List<Integer> list ;
    private static HashMap<Integer,Integer> map ;

    public static void main(String[] args) {
        LRUCache(2);
        put(1,1);put(2,2);
        int i1 = get(1);
        System.out.println(i1);
        put(3,3);
        int i2 = get(2);
        System.out.println(i2);
        put(4,4);
        int i3 = get(1);
        System.out.println(i3);
        int i4 = get(3);
        System.out.println(i4);
    }

    public static void LRUCache(int capacity) {
        size = capacity ;
        list = new ArrayList<>() ;
        map = new HashMap<Integer, Integer>() ;
    }

    public static int get(int key) {
        if(map.containsKey(key)){
            list.remove(Integer.valueOf(key)) ;
            list.add(0 , key) ;
        }
        System.out.println(list);
        return map.getOrDefault(key , -1) ;
    }

    public static void put(int key, int value) {
        if (list.size() < size){
            if (map.containsKey(key)){
                list.remove(key) ;
                list.remove(Integer.valueOf(key)) ;
            }
        }else {
            if (map.containsKey(key)){
                list.remove(Integer.valueOf(key)) ;
            }else {
                map.remove(list.get(size-1)) ;
                list.remove(size - 1) ;
            }
        }
        list.add(0 , key) ;
        map.put(key , value) ;
    }
}
