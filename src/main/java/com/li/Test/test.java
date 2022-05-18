package com.li.Test;

/**
 * @Author: li wei kai
 * @Date: 2022/05/18/17:30
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20} ;
        boolean lemonadeChange = lemonadeChange(bills);
        System.out.println(lemonadeChange);

    }
    public static boolean lemonadeChange(int[] bills) {
        int num1 = 0 , num2 = 0 ;
        if(bills[0] > 5) return false ;
        for(int i = 0 ; i < bills.length ; i++){
            if(bills[i] == 5){
                num1++ ;
            }else if(bills[i] == 10){
                num2++ ;
            }
            if(num1 < 0 || num2 < 0) return false ;
            if(bills[i] == 10){
                num1-- ;
            }
            if(bills[i] == 20){
                if(num2 > 0 && num1 > 0){
                    num2-- ;
                    num1-- ;
                }else if(num1 >= 3){
                    num1 -= 3 ;
                }else {
                    return false ;
                }
            }
        }
        return true ;
    }
}
