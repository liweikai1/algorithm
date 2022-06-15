package com.li.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Author: li wei kai
 * @Date: 2022/06/10/16:48
 * @Description:leetcode T380 题目：O(1) 时间插入、删除和获取随机元素
 题目描述：
实现RandomizedSet 类：
    RandomizedSet()： 初始化 RandomizedSet 对象
    bool insert(int val)： 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
    bool remove(int val)： 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
    int getRandom()： 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
示例：
    输入：["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
        [[], [1], [2], [2], [], [1], [2], []]
    输出：[null, true, false, true, 2, true, false, 2]
    解释：
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
 */
public class insertDeleteGetRandomO1 {
    private static HashMap<Integer , Integer> map ;
    private static List<Integer> list ;
    private static Random random ;

    //思路：变长数组(ArrayList<>()) + 哈希表(HashMap<>())
    //变长数组可以在 O(1) 的时间内完成随机访问元素操作，但是由于无法在 O(1) 的时间内判断元素是否存在，
    //   因此不能在 O(1) 的时间内完成插入和删除操作。
    //哈希表可以在 O(1) 的时间内完成插入和删除操作，但是由于无法根据下标定位到特定元素，因此不能在 O(1)
    //   的时间内完成随机访问元素操作。
    //为了满足插入、删除和随机访问元素操作的时间复杂度都是 O(1)，需要将变长数组和哈希表结合，
    // 变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。
    public static void main(String[] args) {
        RandomizedSet();
        boolean insert1 = insert(1);System.out.println(insert1);
        System.out.println("list为" + list);
        boolean remove1 = remove(2);System.out.println(remove1);
        boolean insert2 = insert(2);System.out.println(insert2);
        System.out.println("list为" + list);
        int random1 = getRandom();      System.out.println(random1);
        boolean remove2 = remove(1);System.out.println(remove2);
        boolean insert3 = insert(2);  System.out.println(insert3);
        System.out.println("list为" + list);
        int random2 = getRandom();      System.out.println(random2);

    }
    /**
    * @Description: 初始化数组和哈希表
    * @Param: []
    * @return: void
    * @Date: 2022/6/10
    */
    public static void RandomizedSet() {
        map = new HashMap<Integer , Integer>() ;
        list = new ArrayList<>() ;
        random = new Random() ;
    }

    /**
    * @Description: 添加元素
    插入操作时，首先判断 val 是否在哈希表中，如果已经存在则返回 false，如果不存在则插入 val，操作如下：
        1.在变长数组的末尾添加 val；
        2.在添加 val 之前的变长数组长度为 val 所在下标 index，将 val 和下标 index 存入哈希表；
        3.返回 true。
    * @Param: [val]
    * @return: boolean
    * @Date: 2022/6/10
    */
    public static boolean insert(int val) {
        if (map.containsKey(val)){
            return false ;
        }else{
            map.put(val , list.size()) ;
            list.add(val) ;
            return true ;
        }
    }

    /**
    * @Description: 删除元素
    删除操作时，首先判断 val 是否在哈希表中，如果不存在则返回 false，如果存在则删除 val，操作如下：
        1.从哈希表中获得 val 的下标 index；
        2.将变长数组的最后一个元素 last 移动到下标 index 处，在哈希表中将 last 的下标更新为 index；
        3.在变长数组中删除最后一个元素，在哈希表中删除 val；
        4.返回 true。
    删除操作的重点在于将变长数组的最后一个元素移动到待删除元素的下标处，然后删除变长数组的最后一个元素。该操作的
    时间复杂度是 O(1)，且可以保证在删除操作之后变长数组中的所有元素的下标都连续，方便插入操作和随机访问元素操作。
    * @Param: [val]
    * @return: boolean
    * @Date: 2022/6/10
    */
    public static boolean remove(int val) {
        if (map.containsKey(val)){
            int ind = map.get(val) ;
            int num = list.get(list.size() - 1) ;
            list.set(ind , num) ;
            map.put(num , ind) ;
            map.remove(val) ;
            list.remove(list.size() - 1) ;
            return true;
        }else{
            return false ;
        }
    }

    /**
    * @Description: 随机访问元素
    随机访问元素操作时，由于变长数组中的所有元素的下标都连续，因此随机选取一个下标，返回变长数组中该下标处的元素。
    * @Param: []
    * @return: int
    * @Date: 2022/6/10
    */
    public static int getRandom() {
        return list.get(random.nextInt(list.size())) ;
    }
}
