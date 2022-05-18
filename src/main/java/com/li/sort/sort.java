package com.li.sort;


import java.text.SimpleDateFormat;
import java.util.*;

public class sort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,8,0,4,10,-1} ;
        //根据需求复制数组的前几位数
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 3)));

        List<Integer> list = new ArrayList<>() ;
        list.add(9) ;
        list.add(2) ;
        list.add(8) ;

        int[] temp = new int[arr.length] ;
        System.out.println("排序前:" + Arrays.toString(arr));
        //bubbleSort(arr); //冒泡排序
        //selectSort(arr); //选择排序
        //insertionSort(arr); //插入排序
        //shellSort(arr); //希尔排序
        //quickSort(arr ,0 , arr.length - 1); //快速排序 左边一点为基准
        quickSort2(arr ,0 , arr.length - 1); //快速排序 中间一点为基准
        //quickSort3(arr ,0 , arr.length - 1); //快速排序 右边一点为基准
        //mergeSort(arr,0,arr.length - 1,temp); //归并排序
        //radixSort(arr); //基数排序
        System.out.println("排序后:" + Arrays.toString(arr));


        //test(); // 测试80000个数据排序需要的时间。
    }

    /**
    * @Description: 用800000个数据测试排序方式执行的时间
    * @Param: []
    * @return: void
    * @Date: 2021/12/2
    */
    public static void test(){
        spendTime();
        int[] arr2 = new int[80000] ;
        int[] temp = new int[arr2.length] ;
        for (int i=0 ; i< 80000 ; i++){
            arr2[i] = (int) (Math.random() * 1000000) ;
        }
        //bubbleSort(arr2); //冒泡排序
        //selectSort(arr2); //选择排序
        //insertionSort(arr2); //插入排序
        //shellSort(arr2); //希尔排序
        //quickSort(arr2,0,arr2.length-1); //快速排序
        //quickSort2(arr2,0,arr2.length-1); //快速排序
        //mergeSort(arr2,0,arr2.length - 1,temp); //归并排序
        spendTime();
    }
    /**
    * @Description: 日期格式化,当有大量数据排序时，用来测试排序算法所需时间。
    * @Param: []
    * @return: void
    * @Date: 2021/12/2
    */
    public static void spendTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format = dateFormat.format(date);
        System.out.println("现在的时间为:" + format);
    }

    /**
    * @Description: 冒泡排序法:冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，
     * 一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
     * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * 算法步骤
     * 1）比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2）对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3）针对所有的元素重复以上的步骤，除了最后一个。
     * 4）持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
    * @Param: [arr] ：数组
    * @return: void
    * @Date: 2021/12/2
    */
    public static  void bubbleSort(int[] arr){
        int temp = 0 ;
        //优化冒泡排序，如果当此循环未排序，说明已经排列好，以后就不需要排序了。
        //flag:标志变量 ，表示是否进行过排序
        boolean flag = false ;
        for (int i = 0 ; i < arr.length - 1 ; i ++){
            for (int j = 0 ; j < arr.length - 1 -i ; j++ ){
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true ;
                }
            }
            if(!flag){
                //表示flag为false时，未进行内循环的if判断，说明已经排序好了 直接退出循环就行。
                break;
            }else {
                //表示flag进入过内循环 ，需要将flag重新置为false，以便进行下次循环。
                flag = false ;
            }
        }
    }
    /**
    * @Description: 选择排序法:选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *算法步骤
     * 1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2）再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 3）重复第二步，直到所有元素均排序完毕。
    * @Param: [arr] :数组
    * @return: void
    * @Date: 2021/12/2
    */
    public static void selectSort(int[] arr){
        for (int i = 0 ;i < arr.length - 1 ; i ++){
            int minIndex = i ;
            int temp = arr[i] ;
            for (int j = i +1 ; j < arr.length ; j++){
                if (temp > arr[j]){
                    minIndex = j ;
                    temp = arr[j] ;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i] ;
                arr[i] = temp ;
            }
        }
     }

     /**
     * @Description: 插入排序法：插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
      * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
      * 插入排序在实现上，通常采用in-place排序（即只需用到 O(1)的额外空间的排序），因而在从后向前扫
      * 描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
      * 算法步骤：
      * 1）从第一个元素开始，该元素可以认为已经被排序；
      * 2）取出下一个元素，在已经排序的元素序列中从后向前扫描；
      * 3）如果该元素（已排序）大于新元素，将该元素移到下一位置；
      * 4）重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
      * 5）将新元素插入到该位置后；
      * 6）重复步骤2~5。
      *
     * @Param: [arr]
     * @return: void
     * @Date: 2021/12/2
     */
     public static void insertionSort(int[] arr){
         int temp = 0 ;
         int index = 0 ;
          for (int i = 1 ; i < arr.length ; i++){
             temp = arr[i] ;
             index = i - 1 ;
             while (index >= 0 && temp < arr[index]){
                 arr[index + 1] = arr[index] ;
                 index-- ;
             }
             if (index + 1 != i){
                 arr[index + 1] = temp ;
             }
         }
     }

     /**
     * @Description: 希尔排序：又叫缩小增量排序。希尔排序是将待排序的数组元素 按下标的一定增量分组 ，分成多个子序列，
      * 然后对各个子序列进行直接插入排序算法排序；然后依次缩减增量再进行排序，直到增量为 1 时，进行最后一次
      * 直接插入排序，排序结束。
      * 算法步骤：
      * 1）选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
      * 2）按增量序列个数k，对序列进行k 趟排序；
      * 3）每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
      *    仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @Param: [arr]
     * @return: void
     * @Date: 2021/12/2
     */
     public static void shellSort(int[] arr){
        int temp = 0;
        int index = 0 ;
        for (int gap = arr.length / 2 ; gap > 0 ; gap /= 2){
            for (int i = gap ; i < arr.length ; i ++){
                temp = arr[i] ;
                index = i  ;
                while (index - gap >= 0 && temp < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                arr[index] = temp ;
            }
            //System.out.println(Arrays.toString(arr));
        }
     }

     /**
     * @Description: 快速排序法：基本思想是通过一趟排序将待排记录分隔成独立的两部分，其中一部分
      * 记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
      * 算法步骤：快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。
      * 1）从数列中挑出一个元素，称为 “基准”（pivot）；
      * 2）重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以
      *   到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
      * 3）递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @Param: [arr, left, right]
      * arr:传递的数组
      * left:数组的左下表
      * right:数组的右下标
     * @return: void
     * @Date: 2021/12/3
     */
     //快速排序法 以左边第一点为基准
     public static void quickSort(int[] arr , int left , int right){
         if (left < right) {
             int pivot = arr[left];
             int l = left;
             int r = right;
             while (l < r) {
                 while (l < r && arr[r] > pivot) {
                     r--;
                 }
                 if (l < r) {
                     arr[l] = arr[r];
                     l++;
                 }
                 while (l < r && arr[l] < pivot) {
                     l++;
                 }
                 if (l < r) {
                     arr[r] = arr[l];
                     r--;
                 }
             }
             arr[r] = pivot ;
             quickSort(arr, left, r - 1);
             quickSort(arr, l + 1, right);
         }
     }

    //快速排序法 以中间一点为基准
    public static void quickSort2(int[] arr , int left , int right){
         int pivot = arr[(left + right) / 2] ;
         int l = left ;
         int r = right ;
         int temp = 0 ;
         while (l < r){
             while (arr[l] < pivot){
                 l ++ ;
             }
             while (arr[r] > pivot){
                 r -- ;
             }
             if (l >= r){
                 break ;
             }
             temp = arr[l] ;
             arr[l] = arr[r] ;
             arr[r] = temp ;

             if (arr[l] == pivot){
                 r -- ;
             }
             if (arr[r] == pivot){
                 l ++ ;
             }
         }
         if (l == r){
             l ++ ;
             r -- ;
         }
         if (left < r){
             quickSort2(arr , left , r);
         }
         if (right > l){
             quickSort2(arr , l , right);
         }
    }

    //快速排序法 以右边第一点为基准
    public static void quickSort3(int[] arr , int left , int right) {
        if (left < right) {
            int pivot = arr[right];
            int l = left;
            int r = right;
            while (l < r) {
                while (l < r && arr[l] < pivot) {
                    l++;
                }
                if (l < r) {
                    arr[r] = arr[l];
                    r--;
                }
                while (l < r && arr[r] > pivot) {
                    r--;
                }
                if (l < r) {
                    arr[l] = arr[r];
                    l++;
                }
            }
            arr[l] = pivot;
            quickSort3(arr, left, r - 1);
            quickSort3(arr, l + 1, right);
        }
    }

    /**
    * @Description: 归并排序:（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
     * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
     * 算法步骤：
     * 1）申请空间，使其大小为两个已经排序序列之和  ，该空间用来存放合并后的序列；
     * 2）设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     * 3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     * 4）重复步骤 3 直到某一指针达到序列尾；
     * 5）将另一序列剩下的所有元素直接复制到合并序列尾。
     *
    * @Param: [arr:需要进行排序的数组；
     *        left: 数组的左边界；
     *         right:数组的右边界]
    * @return: void
    * @Date: 2021/12/8
    */
    public static void mergeSort(int[] arr , int left ,int right , int[] temp){
        if (left < right){
            int mid = (left + right) /2 ;
            mergeSort(arr , left , mid , temp);
            mergeSort(arr , mid + 1 , right ,temp);
            merge(arr , left , mid ,right ,temp);
        }
    }
    /**
    * @Description: 合并两个数组，也可以用于合并链表
    * @Param: [arr, left, mid, right, temp]
    * @return: void
    * @Date: 2021/12/8
    */
    public static void merge(int[] arr , int left , int mid , int right , int[] temp){
        int l = left ;
        int r = right ;
        int j = mid + 1 ;
        int t = 0 ;
        //1.先把左右两边有序的数组按照规则填充到temp数组，直到左右两边的有序序列有一边处理完毕。
        while (l <= mid && j <= r){
            if (arr[l] <= arr[j]){
                temp[t] = arr[l] ;
                l += 1 ;
            }else {
                temp[t] = arr[j] ;
                j += 1 ;
            }
            t += 1 ;

        }
        //2.把有剩余数据的一边的数据一次全部填充到temp数组
        while (l <= mid){
            temp[t] = arr[l] ;
            l += 1 ;
            t += 1 ;
        }
        while (j <= r){
            temp[t] = arr[j] ;
            j += 1 ;
            t += 1 ;
        }
        //3.将temp数组拷贝到arr数组.注意：并不是每次都拷贝所有的
        t = 0 ;
        int tempLeft = left ;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t] ;
            t += 1;
            tempLeft += 1;
        }
    }
    /**
    * @Description: 基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的位数；
     * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，
     * 先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
     * 基数排序基于分别排序，分别收集，所以是稳定的。
     * 算法步骤：
     * 1）取得数组中的最大数，并取得位数；
     * 2）arr为原始数组，从最低位开始取每个位组成radix数组；
     * 3）对radix进行计数排序（利用计数排序适用于小范围数的特点）；
    * @Param: [arr]:传进的数组
    * @return: void
    * @Date: 2021/12/8
    */
    public static void  radixSort(int[] arr){
        int max = arr[0] ;
        for (int i = 0 ; i < arr.length - 1 ; i ++){
            if (arr[i] > max){
                max = arr[i] ;
            }
        }
        //计算出最大数共有几位数
        int len = (max + "").length() ;

        //二维数组包含10个以为数组，为了防止在添加数据的时候发生溢出，每个一维数组的大小定义为arr.length
        int[][] bucket = new int[10][arr.length] ;

        //为了记录每个桶中实际存放了多少个数据，定义一个一维数组来记录各个桶每次被放入的个数
        //比如：bucketElements[1],记录的就是bucket[1]桶中放入的数据个数。
        int[] bucketElements = new int[10] ;

        //按照最大数的位数循环判断
        for (int l = 0 ,n = 1; l < len ; l++ , n = n*10){
            //遍历数组，按照相应位数的数字将其放入对应的桶中，
            for (int i = 0 ; i < arr.length ; i ++){
                int val = arr[i] / n % 10 ;
                bucket[val][bucketElements[val]] = arr[i] ;
                bucketElements[val] ++ ;
            }

            //从桶中取出数字
            int index = 0 ;
            for (int j = 0 ; j < bucketElements.length ; j ++){
                if (bucketElements[j] != 0){
                    for (int k = 0 ;k < bucketElements[j] ; k++){
                        arr[index] = bucket[j][k] ;
                        index ++ ;
                     }
                }
                //为了下一轮能正常循环，需要将当前这一轮的bucketElements重置为0
                bucketElements[j] = 0 ;
            }
            System.out.println(Arrays.toString(arr));
        }
        /*int val = 0 ;
        for (int i = 0 ; i < arr.length - 1  ; i ++){
             if (Math.abs(arr[i] - arr[i+1]) > val){
                 val = Math.abs(arr[i] - arr[i+1]) ;
             }
        }
        System.out.println("val的最大值为：" + val);*/
    }

}
