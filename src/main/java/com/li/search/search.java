package com.li.search;

import java.util.Collections;

/**
 * @Author: li wei kai
 * @Date: 2022/03/24/15:34
 * @Description:
 */
public class search {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6} ;
        int target = 0 ;
        int binarySearch = binarySearch(nums, target);
        System.out.println("二分查找的结果为" + binarySearch);

    }

    /**
    * @Description: 二分查找 ；
     * 也称为是折半查找，属于有序查找算法（要求：要查找的数组必须是有序的）。用给定值k先与中间结点的关键字比较，
     * 中间结点把线形表分成两个子表，若相等则查找成功；若不相等，再根据k与该中间结点关键字的比较结果
     * 确定下一步查找哪个子表，这样递归进行，直到查找到或查找结束发现表中没有这样的结点。
    * @Param: [nums, target]
    * @return: int
    * @Date: 2022/3/24
     * 注意： 求中间值时不要用 (low +high) / 2。可能会产生溢出错误。
     * 为什么(low +high) / 2会溢出啊？答：两个很大的int相加的话超出 Integer.MAX_VALUE了
    */
    public static int binarySearch(int[] nums , int target){
        int low = 0 ;
        int high = nums.length - 1 ;
        while (low <= high){
            int mid = low + (high - low)/ 2 ;
            if (nums[mid] == target){
                return mid ;
            }
            if (nums[mid] < target){
                low = mid + 1 ;
            }
            if (nums[mid] > target){
                high = mid - 1;
            }
        }
        return -1 ;
    }

}
