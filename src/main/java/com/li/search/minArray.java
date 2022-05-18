package com.li.search;

/**
 * @Author: li wei kai
 * @Date: 2022/03/25/18:21
 * @Description:题目： 旋转数组的最小数字
  描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。给
      你一个可能存在重复元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
      请返回旋转数组的最小元素。
      例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
示例 1：
    输入：numbers = [3,4,5,1,2]
    输出：1 
 *
 *
 */
public class minArray {
    public static void main(String[] args) {
        int[] arr = {2,2,2,0,1} ;
        int[] arr1 = {2,0,1,2,2} ;
        int[] arr2 = {1,2,3,4} ;
        int[] arr3 = {1,1} ;
        int minArray = minArray(arr1);
        System.out.println("旋转数组的最小数字为：" + minArray);

    }
    /**
    * @Description: 二分法：需要注意边界的取值
 当 nums[mid] > nums[high]时：mid一定在左排序数组中，即旋转点 x一定在 [mid+1,high]闭区间内，因此执行 low=mid+1；
 当 nums[mid] < nums[high]时：mid一定在右排序数组中，即旋转点 x一定在[low, mid]闭区间内，因此执行 high=mid；
 当 nums[mid] = nums[high]时：无法判断 m在哪个排序数组中，即无法判断旋转点 x在[low,mid]还是 [mid+1,high]区间中。
    解决方案： 执行 high = high-1缩小判断范围。

    * @Param: [numbers]
    * @return: int
    * @Date: 2022/3/25
    */
    public static int minArray(int[] numbers) {
        int low = 0 ;
        int high = numbers.length - 1 ;
         while(low < high){
            int mid = low + (high - low) / 2 ;
            if (numbers[mid] < numbers[high]){
                high = mid ;
            }else if (numbers[mid] > numbers[high]){
                low = mid + 1 ;
            }else {
                high-- ;
            }
        }
         return numbers[low] ;
    }
}
