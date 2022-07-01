package com.li.reflect;

/**
 * @Author: li wei kai
 * @Date: 2022/07/01/11:23
 * @Description:
 */
public class TargetObject {

    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
