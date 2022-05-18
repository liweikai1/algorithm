package com.li.binaryTree;

/**
 * @Author: li wei kai
 * @Date: 2022/02/20/20:53
 * @Description:
 */
public class HeroNode1 {
    public int no ;
    public String name ;
    public HeroNode1 left ;
    public HeroNode1 right ;

    public HeroNode1(int no) {
        this.no = no;
    }

    public HeroNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode1(int no, String name, HeroNode1 left, HeroNode1 right) {
        this.no = no;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
