package com.li.array;

/**
 * @Author: li wei kai
 * @Date: 2022/04/10/16:50
 * @Description:
 */
public class verifyPostOrder {
    public static void main(String[] args) {
        int[] postOrder = {1,2,3,4,5,6} ;
        boolean order = verifyPostOrder(postOrder);
        System.out.println(order);

    }
    public static boolean verifyPostOrder(int[] postorder) {
        return recur(postorder , 0 , postorder.length - 1) ;
    }
    public static boolean recur(int[] postorder , int i , int j){
        if(i >= j) return true ;
        int k = i ;
        while(postorder[k] < postorder[j]) k++ ;
        int m = k ;
        while(postorder[k] > postorder[j]) k++ ;
        return k == j && recur(postorder , i , m-1) && recur(postorder , m , j-1) ;
    }
}
